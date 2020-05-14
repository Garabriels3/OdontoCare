package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.EmployeeRegisterDAO;
import br.com.odonto.DAO.LoginDAO;
import br.com.odonto.model.LoginModel;

public class LoginController {
<<<<<<< HEAD
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
=======
	private static LoginController INSTANCE;
	private LoginDAO loginDAO;
	private LoginController() {
		
	}
	public static LoginController getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new LoginController();
		}
		return INSTANCE;
	}
	public boolean verificarLogin(String senha, String email)throws Exception{
		loginDAO = LoginDAO.getINSTANCE();
		boolean check = false;
		if(senha != null && senha.length() > 0 && email != null && email.length() > 0) {
			return loginDAO.verificarLogin(senha, email);
>>>>>>> origin/FuncionarioCRUD
		}
		return check;
	}
	
}

