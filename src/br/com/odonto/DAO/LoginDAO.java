package br.com.odonto.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.odonto.model.EmployeeRegisterModel;
import br.com.odonto.model.LoginModel;
import br.com.odonto.util.ConnectionFactory;

public class LoginDAO {
	private static LoginDAO INSTANCE;
	private ConnectionFactory connectionFactory;
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private String sql;
	
	private LoginDAO() {
		
	}
	public static LoginDAO getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new LoginDAO();
		}
		return INSTANCE;
	}
	

}
