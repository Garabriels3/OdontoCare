package br.com.odonto.controller;
//AUTHOR: Felipe Pereira dos Santos(21192057)
import javax.swing.JOptionPane;

import br.com.odonto.DAO.EmployeeDAO;
import br.com.odonto.model.EmployeeModel;

public class EmployeeController {
	private static EmployeeController INSTANCE;
	private EmployeeDAO employeeRegisterDAO = new EmployeeDAO();; 
	private EmployeeModel employee;
	
	private EmployeeController() {
	}
	public static EmployeeController getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new EmployeeController();
		}
		return INSTANCE;
	}
	public boolean saveEmployeeData(String cpf,String nome,String funcao,String email,String senha) throws Exception{
		boolean success = false;
		if(cpf.length() > 0 && nome.length() > 0 && funcao.length() > 0 && email.length() > 0 && senha.length() > 0) {
			if(nome.matches(".*\\d+.*") == false && funcao.matches(".*\\d+.*") == false && cpf.matches("[0-9]+")) {
				employee = new EmployeeModel(cpf, nome, funcao, email, senha);
				success = employeeRegisterDAO.saveEmployeeData(employee);
			}
		}
		return success;	
	}
	
}
