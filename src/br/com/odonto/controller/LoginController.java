package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.EmployeeRegisterDAO;
import br.com.odonto.DAO.LoginDAO;
import br.com.odonto.model.LoginModel;

public class LoginController {
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

	
}

