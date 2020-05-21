package br.com.odonto.DAO;

//AUTHOR: Gabriel dos Santos(21285136)
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.odonto.model.EmployeeModel;
import br.com.odonto.model.LoginModel;
import br.com.odonto.util.ConnectionFactory;

public class LoginDAO {
	private ConnectionFactory connectionFactory;
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private String sql;
	
	public boolean checkLogin(LoginModel user) throws Exception {
		try {
			boolean success = false;
			connectionFactory = new ConnectionFactory();
			sql = "SELECT * FROM funcionario WHERE email_func = ? and senha_func = ?";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				success = true;
			}
			return success;
		} finally {
			connectionFactory.closeConnection(con, stmt, rs);
		}

	}
	public boolean saveNewPassword(String cpf, String email, String password) throws Exception{
		boolean success = false;
		try {
			connectionFactory = new ConnectionFactory();
			sql = "UPDATE funcionario SET senha_func = ? WHERE cpf_func = ? and email_func = ?";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, cpf);
			stmt.setString(3, email);
			int i = stmt.executeUpdate();	
			if( i > 0) {
				success = true;
			}			
			return success;
		} finally {
			connectionFactory.closeConnection(con,stmt);
		}
	
	}
}
