package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.EmployeeRegisterDAO;
import br.com.odonto.model.EmployeeRegisterModel;

public class EmployeeRegisterController {
	private static EmployeeRegisterController INSTANCE;
	private EmployeeRegisterDAO employeeRegisterDAO; 
	private EmployeeRegisterModel employee;
	
	private EmployeeRegisterController() {
	}
	public static EmployeeRegisterController getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new EmployeeRegisterController();
		}
		return INSTANCE;
	}
	public boolean salvarDados(String cpf,String nome,String funcao,String email,String senha) throws Exception{
		employeeRegisterDAO = EmployeeRegisterDAO.getINSTANCE();
		boolean check = false;
		if(cpf.length() > 0 && nome.length() > 0 && funcao.length() > 0 && email.length() > 0 && senha.length() > 0) {
			if(nome.matches(".*\\d+.*") == false && funcao.matches(".*\\d+.*") == false && cpf.matches("[0-9]+")) {
				employee = new EmployeeRegisterModel(cpf, nome, funcao, email, senha);
				return employeeRegisterDAO.salvarDados(employee);
			}
		}
		return check;
	}
	
}
