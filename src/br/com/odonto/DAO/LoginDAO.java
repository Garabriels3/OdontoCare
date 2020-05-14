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
	private ConnectionFactory connectionFactory;
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private String sql;
	boolean check;
	
	public boolean checkLogin(LoginModel user) throws Exception {
		
		try {
			boolean check = false;
			connectionFactory = new ConnectionFactory();
			sql = "SELECT * FROM funcionario WHERE senha = ? and email = ?";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				check = true;
			}
			return check;
		} finally {
			connectionFactory.closeConnection(con, stmt, rs);
	
	}

}
}
