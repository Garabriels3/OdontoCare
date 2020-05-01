package br.com.odonto.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static String login;
	private static String password;
	private static String url;
	public static Connection getConnection() throws Exception {
		try {
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
}
