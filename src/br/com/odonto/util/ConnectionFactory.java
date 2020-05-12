package br.com.odonto.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	//Padrão de Projeto Singleton - uma única instância da classe 
	private static ConnectionFactory INSTANCE; //Declaração de uma variavel do tipo ConnectionFactory
	
	private ConnectionFactory() { // Construtor privado, para evitar a criação instâncias da classe.
	}
	public static ConnectionFactory getINSTANCE() { //Método para a criação de uma única instância da classe
		if(INSTANCE == null){
			INSTANCE = new ConnectionFactory();
		}
		return INSTANCE;
	}

	public Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String login = "root";
			String senha = "71463771";
			String url = "jdbc:mysql://localhost:3306/odonto";
			return DriverManager.getConnection(url, login, senha);
		}
		catch(Exception e) {
			System.out.println("Erro Ao conectar");
			e.printStackTrace();
		}
		return null;
	}
	
	public  void closeConnection(Connection con) {
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
