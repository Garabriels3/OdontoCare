package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.LoginDAO;
import br.com.odonto.model.LoginModel;

public class LoginController {

		public boolean singUp(String login, String password) throws Exception {
			boolean sucess;
			if(login != null && login.length() > 0 && password != null && password.length() > 0) {
				LoginModel user = new LoginModel(login, password);
				LoginDAO loginDAO = new LoginDAO();
				
				sucess = loginDAO.checkLogin(user);
				return sucess;
			}
			return false;
			}
		}

