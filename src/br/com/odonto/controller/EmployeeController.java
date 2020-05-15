package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.EmployeeDAO;
import br.com.odonto.model.EmployeeModel;

public class EmployeeController {
	private static EmployeeController INSTANCE;
	private EmployeeDAO employeeRegisterDAO; 
	private EmployeeModel employee;
	
	private EmployeeController() {
	}
	public static EmployeeController getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new EmployeeController();
		}
		return INSTANCE;
	}
	public boolean salvarDados(String cpf,String nome,String funcao,String email,String senha) throws Exception{
		employeeRegisterDAO = new EmployeeDAO();
		boolean check = false;
		if(cpf.length() > 0 && nome.length() > 0 && funcao.length() > 0 && email.length() > 0 && senha.length() > 0) {
			if(nome.matches(".*\\d+.*") == false && funcao.matches(".*\\d+.*") == false && cpf.matches("[0-9]+")) {
				employee = new EmployeeModel(cpf, nome, funcao, email, senha);
				return employeeRegisterDAO.salvarDados(employee);
			}
		}
		return check;	
	}
	
}
