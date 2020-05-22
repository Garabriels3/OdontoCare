package br.com.odonto.controller;
//AUTHOR: Felipe Pereira dos Santos(21192057)
import javax.swing.JOptionPane;

import br.com.odonto.DAO.EmployeeDAO;
import br.com.odonto.model.EmployeeModel;

public class EmployeeController {
	private EmployeeDAO employeeDAO = new EmployeeDAO();; 
	private EmployeeModel employee;
	
	public EmployeeController() {
	}

	public boolean saveEmployeeData(String cpf,String nome,String funcao,String email,String senha) throws Exception{
		boolean success = false;
		if(cpf.length() > 0 && nome.length() > 0 && funcao.length() > 0 && email.length() > 0 && senha.length() > 0) {
			if(nome.matches(".*\\d+.*") == false && funcao.matches(".*\\d+.*") == false && cpf.matches("[0-9]+")) {
				employee = new EmployeeModel(cpf, nome, funcao, email, senha);
				success = employeeDAO.saveEmployeeData(employee);
			}
		}
		return success;	
	}
	public boolean excludeEmployeeData(String cpf)throws Exception{
		boolean success = false;
		if(cpf.length() > 10) {
			success = employeeDAO.deleteEmployeeData(cpf);
		}
		return success;
	}
	
}
