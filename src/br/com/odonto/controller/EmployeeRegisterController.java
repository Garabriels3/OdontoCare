package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.EmployeeRegisterDAO;
import br.com.odonto.model.EmployeeRegisterModel;

public class EmployeeRegisterController {
	private static EmployeeRegisterController INSTANCE;
	private EmployeeRegisterDAO employeeRegisterDAO;
	
	private EmployeeRegisterController() {
	}
	public static EmployeeRegisterController getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new EmployeeRegisterController();
		}
		return INSTANCE;
	}
	public void salvarDados(EmployeeRegisterModel employee) throws Exception{
		employeeRegisterDAO = EmployeeRegisterDAO.getINSTANCE();
		employeeRegisterDAO.salvarDados(employee);
	}
	
}
