package br.com.odonto.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class CepApi {
	String path;
	String BASEURL = "http://viacep.com.br/ws/08474340/json/";
	static CepApi instance;
	
	CloseableHttpClient clientHTTP;
	
	private CepApi() {
		this.clientHTTP = HttpClients.createDefault();
	}
	
	public static CepApi getInstance() {
		if (instance == null) {
			instance = new CepApi();
		}
		return instance;
	}
	
	public String doRequest(String path) {
		this.path = path;
		String responseBody = null;
		
		try {

			HttpGet httpGet = new HttpGet(this.BASEURL);
			
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				@Override
				public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						
						return entity != null ? EntityUtils.toString(entity) : null;
					}else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};
			responseBody = this.clientHTTP.execute(httpGet, responseHandler);
		}catch(IOException e) {
			System.out.println("Erro: " +e);
		}
		return responseBody;
	}
	
}
