package br.com.odonto.DAO;

import java.awt.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.odonto.model.CepModel;
import br.com.odonto.service.CepApi;

public class ClientRegisterDao {
	private Gson gson = new GsonBuilder().create(); // Gson � uma library, que converte Json para Objeto manipulavel, ou de Obejto para Json (fromJson, toJson)
    private CepModel data; // Variavel do tipo da Model, para manipular a api atrav�s de objetos Java
	private String json;
	private Type type;
	private CepApi instance;
	
	public CepModel convertApi(String path) {
		instance = CepApi.getInstance(); // Usamos a instancia do Singleton, para instanciar a classe, de forma Unica
		json = instance.doRequest(path); // Aqui atribuimos a variavel json, o retorno de doRequest, que retornar� o JSON puro sem convers�o
		type = new TypeToken<CepModel>() {}.getType(); // Aqui fazemos um TypeToken, do tipo Generico CepModel
		
			data = gson.fromJson(json, type); // Inicializamos a var data com os dados vindos da API de forma Convertida, para Objeto, para que possamos acessar
		
		return data; // retorna os dados da API, agora j� convertidos objetos manipulaveis dentro da linguagem Java
	}
}


