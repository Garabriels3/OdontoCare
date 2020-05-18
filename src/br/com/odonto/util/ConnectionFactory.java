package br.com.odonto.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//AUTHOR: GABRIEL DOS SANTOS NASCIMENTO(21285136)

public class ConnectionFactory {
	private static String login;
	private static String password;
	private static String url;

	public Connection getConnection() throws Exception {
		try {
			System.out.println("Chegou no ConnectionFactory");
			Class.forName("com.mysql.jdbc.Driver");
			login = "root";
			password = "71463771";
			url = "jdbc:mysql://localhost:3306/odonto";
			return DriverManager.getConnection(url, login, password);
		}
		catch(Exception e) {
			System.out.println("Erro Ao conectar");
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con,stmt);
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
