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
	
	// Varivavel do Tipo da pr�rpria classe para fazer Singleton
	static CepApi instance;
	
	private CloseableHttpClient clientHTTP;// Variavel, responsavel por fazer a execu��o da busca da API
	private String BASEURL;
	private String responseBody;
	private ResponseHandler<String> responseHandler;
	private HttpEntity entity;
	private HttpGet httpGet;
	
	// Construtor privado, pois a classe em si n�o � instanciada, e sim o Singleton
	private CepApi() {
		this.clientHTTP = HttpClients.createDefault(); // Inicializa��o do clientHTTP
	}
	
	// Fun��o Publica que faz o Singleton, que � o conceito de instancia unica da classe
	public static CepApi getInstance() {
		if (instance == null) {
			instance = new CepApi(); 
		}
		return instance; // A Func retorna uma instancia da classe, que pode ser acessado por outras classes
	}
	
	// Fun��o que faz a chamada GET da API
	public String doRequest(String path) {
		BASEURL = "http://viacep.com.br/ws/"+path+"/json/"; // URL com EndPoint "path" dinamico, que muda conforme passado no campo CEP pelo usuario
		responseBody = null; //variavel que vai conter o corpo da api, no formato Json
		
		try {

			httpGet = new HttpGet(BASEURL); // init do HTTPGET, passando a URL para que ele possa fazer o GET

			responseHandler = new ResponseHandler<String>() { // Express�o Lambda, que faz um override de uma func da Interface ResponseHanler

				@Override
				public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException { // response � a resposta do servidor onde a API fica, com os dados
					int status = response.getStatusLine().getStatusCode(); // Status serve para pegar o codigo de retorno da requisi��o  API REST
					if (status >= 200 && status < 300) { // Aqui testamos para verificar se o c�digo est� entre 200 e 300, que s�o c�digos de sucesso de retorno da API
						entity = response.getEntity(); // caso der true, inicializamos o response, pegando a Entity
						
						return entity != null ? EntityUtils.toString(entity) : null; //Sendo a requisi��o bem sucedida ou tendo retornado algum erro, normalmente iremos querer obter o conte�do retornado e para isso utilizaremos o objeto HttpEntity
					}else {
						throw new ClientProtocolException("Unexpected response status: " + status); // Aqui ele retornara o c�digo acima de 299, caso de algum erro(URL ERRADA, API OFFLINE, ETC..)
					}
				}
			};
			responseBody = this.clientHTTP.execute(httpGet, responseHandler);// Atrav�s do clientHTTP.execute, executamos a busca usando o httpGet, que pega o retorno do servidor, e o usando o responseHandler nos parametros
		}catch(IOException e) {
			System.out.println("Erro: " +e); // Caso a Api esteja vindo null(Vazia) o erro de Exception ir� ocorrer aqui
		}
		return responseBody; // Retorno final dos dados, em formato Json puro, sem convers�o
	}
	
}
