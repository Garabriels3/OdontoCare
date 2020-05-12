package br.com.odonto.DAO;

import br.com.odonto.util.ConnectionFactory;

public class EmployeeRegisterDAO {
	private static EmployeeRegisterDAO INSTANCE;
	private final ConnectionFactory connectionFactory = ConnectionFactory.getINSTANCE();
	
	private EmployeeRegisterDAO() {	
	}
	public static EmployeeRegisterDAO getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new EmployeeRegisterDAO();
		}
		return INSTANCE;
	}
	

}
