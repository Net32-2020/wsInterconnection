package com.azureclaropayagile.soap.controller.service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azureclaropayagile.soap.controller.AzureController;
import com.azureclaropayagile.soap.entity.DataSendBmc;
import com.azureclaropayagile.soap.entity.issue.RootIssue;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AzureControllerService {
	@Value("${reqPro.connect.octet}")
	private String requestPropertyOctet;
	@Value("${url.azure}")
	private String urlAzure;
	@Value("${url.organizacion}")
	private String organizacion;
	@Value("${url.proyecto}")
	private String proyecto;
	@Value("${url.complemento.buscar.item}")
	private String complemento;
	@Value("${url.complemento.buscar.fin}")
	private String complementoFin;
	@Value("${reqMet.connect.get}")
	private String requestMethod;

	
	@Autowired
	private ApiConnection apiConnection;
	
	public DataSendBmc setDataBmc(RootIssue dataIssue, String patAzure) {

		Logger logger = LoggerFactory.getLogger(AzureController.class);
		
		byte[] arrayImage = new byte[16384];
		DataSendBmc data = new DataSendBmc();

		try {			
			if (dataIssue.relations != null && !dataIssue.relations.isEmpty()) {				
				URL url = new URL(dataIssue.relations.get(dataIssue.relations.size() -1).url);
				arrayImage = getAdjunto(url, patAzure, requestMethod, requestPropertyOctet);
			}
			if (dataIssue.fields.systemDescription != null && !dataIssue.fields.systemState.equals("Done")) {
				data.setLogType(dataIssue.fields.systemTitle);
				data.setLogDate(dataIssue.fields.systemCreatedDate);
				data.setComunicationSource(dataIssue.fields.systemAreaPath);
				data.setDescription(dataIssue.fields.systemDescription);
				data.setDetailDescription(dataIssue.fields.systemHistory);
				data.setLogSubmit(new Date());
				if(dataIssue.relations != null && !dataIssue.relations.isEmpty()) {
					data.setZ2AFWorkLog01(arrayImage);
				}
				data.setStatus(dataIssue.fields.systemState);
				data.setIdBmc(dataIssue.fields.customIdNivelDos);
			} else if (dataIssue.fields.systemState.equals("Done")) {
				data.setIdBmc(dataIssue.fields.customIdNivelDos);
				data.setDetailDescription(dataIssue.fields.systemHistory);
				data.setStatus(dataIssue.fields.systemState);
			}
		} catch (MalformedURLException e) {
			logger.error(e.getMessage());
		}
		return data;
	}
	
	public RootIssue getIssue(Integer id, String encodedPAT, String requestMethod, String requestProperty) {
		RootIssue root = new RootIssue();
		try {
			URL url = new URL(urlAzure+organizacion+proyecto+complemento+id+complementoFin);
			HttpURLConnection con = apiConnection.apiConnectionAttachments(encodedPAT, url,  requestMethod, requestProperty);
			 
			if (con.getResponseCode() == 200) {
				try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
					StringBuilder response = new StringBuilder();
					String responseLine = null;
					while ((responseLine = br.readLine()) != null) {
						response.append(responseLine.trim());
					}
					
					ObjectMapper om = new ObjectMapper();
					root =  om.readValue(response.toString(), RootIssue.class);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return root;
	}

	private byte[] getAdjunto(URL urlImageAzure, String PAT,  String requestMethod, String requestProperty) {
		HttpURLConnection con = apiConnection.apiConnectionAttachments(PAT, urlImageAzure,  requestMethod, requestProperty);
		byte[] arrayImage = new byte[16384];
		try {
			if (con.getResponseCode() == 200) {
				try (InputStream is = con.getInputStream()) {
					arrayImage = getBytesFromInputStream(is);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return arrayImage;
	}
	

	private byte[] getBytesFromInputStream(InputStream is) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte[] buffer = new byte[0xFFFF];
		for (int len = is.read(buffer); len != -1; len = is.read(buffer)) {
			os.write(buffer, 0, len);
		}
		return os.toByteArray();
	}
	

}
