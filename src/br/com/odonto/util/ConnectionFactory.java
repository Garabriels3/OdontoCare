package br.com.odonto.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
<<<<<<< HEAD
	private static String login;
	private static String password;
	private static String url;
	public static Connection getConnection() throws Exception {
=======
	
	//Padr�o de Projeto Singleton - uma �nica inst�ncia da classe 
	private static ConnectionFactory INSTANCE; //Declara��o de uma variavel do tipo ConnectionFactory
	
	private ConnectionFactory() { // Construtor privado, para evitar a cria��o inst�ncias da classe.
	}
	public static ConnectionFactory getINSTANCE() { //M�todo para a cria��o de uma �nica inst�ncia da classe
		if(INSTANCE == null){
			INSTANCE = new ConnectionFactory();
		}
		return INSTANCE;
	}

	public Connection getConnection() throws Exception {
>>>>>>> origin/FuncionarioCRUD
		try {
			System.out.println("Chegou no ConnectionFactory");
			Class.forName("com.mysql.jdbc.Driver");
<<<<<<< HEAD
			login = "root";
			password = "71463771";
			url = "jdbc:mysql://localhost:3306/odonto";
			return DriverManager.getConnection(url, login, password);
=======
			String login = "root";
			String senha = "";
			String url = "jdbc:mysql://localhost:3306/odonto";
			return DriverManager.getConnection(url, login, senha);
>>>>>>> origin/FuncionarioCRUD
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
