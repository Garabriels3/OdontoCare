package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.EmployeeDAO;
import br.com.odonto.DAO.LoginDAO;
import br.com.odonto.model.LoginModel;

//AUTHOR: Gabriel Dos Santos Nascimento(21285136)

public class LoginController {
	private boolean sucess;
	private LoginModel user;
	private LoginDAO loginDAO;
	
	public boolean signIn(String login, String password) throws Exception {
		boolean success = false;
		if (login != null && login.length() > 0 && password != null && password.length() > 0) {
			user = new LoginModel(login, password);
			loginDAO = new LoginDAO();
			success = loginDAO.checkLogin(user);
		}
		return success;
	}
	public boolean saveNewPassword(String cpf, String email, String password) throws Exception{
		boolean success = false;
		if(cpf.length() > 0 && email.length() > 0 && password.length() > 0) {
			loginDAO = new LoginDAO();
			success = loginDAO.saveNewPassword(cpf, email, password);
		}
		return success;
	}
}

