package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.RegisterDao;
import br.com.odonto.model.CepModel;
import br.com.odonto.service.CepApi;

public class RegisterController {
	RegisterDao registerDao = new RegisterDao();
	CepModel data;
	
	public CepModel getAdress(String path) {
		if(path != null) {
			data = registerDao.getApi(path);
		}else {
			JOptionPane.showInternalMessageDialog(null, "Campo Cep não preenchido");
		}
		return data;
	}
}
