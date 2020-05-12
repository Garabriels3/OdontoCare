package br.com.odonto.controller;

import br.com.odonto.DAO.EmployeeRegisterDAO;

public class EmployeeRegisterController {
	private static EmployeeRegisterController INSTANCE;
	private final EmployeeRegisterDAO employeeRegisterDAO = EmployeeRegisterDAO.getINSTANCE();
	private EmployeeRegisterController() {
	}
	public static EmployeeRegisterController getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new EmployeeRegisterController();
		}
		return INSTANCE;
	}

}
