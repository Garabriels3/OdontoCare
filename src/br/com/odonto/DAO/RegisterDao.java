package br.com.odonto.DAO;

import java.awt.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.odonto.model.CepModel;
import br.com.odonto.service.CepApi;

public class RegisterDao {
	Gson gson = new GsonBuilder().create();
    CepModel data;
	
	public CepModel getApi(String path) {
		CepApi instance = CepApi.getInstance();
		String json = instance.doRequest(path);
		Type type = new TypeToken<CepModel>() {}.getType();
		
			data = gson.fromJson(json, type);
		
		return data;
		
	}
}


