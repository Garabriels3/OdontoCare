package br.com.odonto.DAO;

import java.awt.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.odonto.model.CepModel;
import br.com.odonto.service.CepApi;

public class ClientRegisterDao {
	Gson gson = new GsonBuilder().create(); // Gson é uma library, que converte Json para Objeto manipulavel, ou de Obejto para Json (fromJson, toJson)
    CepModel data; // Variavel do tipo da Model, para manipular a api através de objetos Java
	
	public CepModel getApi(String path) {
		CepApi instance = CepApi.getInstance(); // Usamos a instancia do Singleton, para instanciar a classe, de forma Unica
		String json = instance.doRequest(path); // Aqui atribuimos a variavel json, o retorno de doRequest, que retornará o JSON puro sem conversão
		Type type = new TypeToken<CepModel>() {}.getType(); // Aqui fazemos um TypeToken, do tipo Generico CepModel
		
			data = gson.fromJson(json, type); // Inicializamos a var data com os dados vindos da API de forma Convertida, para Objeto, para que possamos acessar
		
		return data; // retorna os dados da API, agora já convertidos objetos manipulaveis dentro da linguagem Java
		
	}
}


