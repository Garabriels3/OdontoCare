package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.EmployeeDAO;
import br.com.odonto.DAO.LoginDAO;
import br.com.odonto.model.LoginModel;

//AUTHOR: GABRIEL DOS SANTOS NASCIMENTO(21285136)

public class LoginController {
	private boolean sucess;
	private LoginModel user;
	private LoginDAO loginDAO;
	
		public boolean signIn(String login, String password) throws Exception {	
			boolean success = false;
			if(login != null && login.length() > 0 && password != null && password.length() > 0) {
				user = new LoginModel(login, password);
				loginDAO = new LoginDAO();
				success = loginDAO.checkLogin(user);
			}
			return success;
			}
}

