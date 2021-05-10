package com.azureclaropayagile.soap.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.azureclaropayagile.soap.controller.service.AzureControllerService;
import com.azureclaropayagile.soap.entity.DataSendBmc;
import com.azureclaropayagile.soap.entity.Root;
import com.azureclaropayagile.soap.entity.issue.RootIssue;
import com.google.gson.Gson;

@RestController
@RequestMapping("/rest")
public class AzureController {

	@Value("${user.ws.bmc}")
	private String usuarioWsBmc;
	@Value("${pass.ws.bmc}")
	private String passWsBmc;
	@Value("${pat.connect.azure}")
	private String patAzure;
	@Value("${reqMet.connect.get}")
	private String requestMethod;
	@Value("${reqPro.connect.json}")
	private String requestPropertyJson;
	
	@Autowired
	private AzureControllerService azureControllerService;


	@Autowired
	private Gson gson;

	@PostMapping(value = "/sendData", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> enviaDatos(@RequestBody Root entity) {

		String AuthStr = ":" + patAzure;
		Base64 base64 = new Base64();
		String encodedPAT = new String(base64.encode(AuthStr.getBytes()));

		if (entity == null) {
			return new ResponseEntity<>("No se encontraron datos de entrada", HttpStatus.BAD_REQUEST);
		}
		if (entity.resource.getWorkItemId() == null) {
			return new ResponseEntity<>("No se encontro el Id del issue", HttpStatus.BAD_REQUEST);
		}

		// llamado al metodo de getIssue
		RootIssue dataIssue = azureControllerService.getIssue(3, encodedPAT, requestMethod, requestPropertyJson);

		DataSendBmc data = azureControllerService.setDataBmc(dataIssue, patAzure);

		String dataStr = gson.toJson(data).toString();
		// llamado al WS de BMC para enviar la data

		return new ResponseEntity<>(dataStr, HttpStatus.OK);
	}

}
