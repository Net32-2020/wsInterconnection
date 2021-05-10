package com.azureclaropayagile.soap.controller.service;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class ApiConnection {

	
	public HttpURLConnection apiConnectionAttachments(String PAT, URL url, String requestProperty, String requestMethod) {
		HttpURLConnection con = null;
		try {
			String AuthStr = ":" + PAT;
			Base64 base64 = new Base64();

			String encodedPAT = new String(base64.encode(AuthStr.getBytes()));
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Authorization", "Basic " + encodedPAT);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestMethod(requestMethod);
			con.setRequestProperty("Content-Type", requestProperty);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
}
