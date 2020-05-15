package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.EmployeeRegisterDAO;
import br.com.odonto.DAO.LoginDAO;
import br.com.odonto.model.LoginModel;

public class LoginController {
	private boolean sucess;
	private LoginModel user;
	private LoginDAO loginDAO;
	
		public boolean signIn(String login, String password) throws Exception {		
			if(login != null && login.length() > 0 && password != null && password.length() > 0) {
				 user = new LoginModel(login, password);
				 loginDAO = new LoginDAO();
				
				sucess = loginDAO.checkLogin(user);
				return sucess;
			}
			return false;
			}

	
}

