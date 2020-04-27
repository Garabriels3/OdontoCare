package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.RegisterDao;

public class RegisterController {
	RegisterDao registerDao = new RegisterDao();
	
	
	public void getAdress(String path) {
		if(path != null) {
			registerDao.getApi(path);
		}else {
			JOptionPane.showInternalMessageDialog(null, "Campo Cep não preenchido");
		}
	}
}
