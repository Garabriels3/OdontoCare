package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.EmployeeRegisterDAO;
import br.com.odonto.DAO.LoginDAO;
import br.com.odonto.model.LoginModel;

public class LoginController {
	private static LoginController INSTANCE;
	private EmployeeRegisterDAO funcionario = EmployeeRegisterDAO.getINSTANCE();
	private LoginController() {
		
	}
	public static LoginController getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new LoginController();
		}
		return INSTANCE;
	}
	public boolean verificarLogin(String senha, String email)throws Exception{
		boolean check = false;
		if(senha != null && senha.length() > 0 && email != null && email.length() > 0) {
			return funcionario.verificarLogin(senha, email);
		}
		return check;
	}
	
}

