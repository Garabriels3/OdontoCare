package br.com.odonto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.odonto.model.EmployeeRegisterModel;
import br.com.odonto.util.ConnectionFactory;

public class EmployeeRegisterDAO {
	private static EmployeeRegisterDAO INSTANCE;
	private ConnectionFactory connectionFactory;
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private String sql;
	
	private EmployeeRegisterDAO() {	
	}
	public static EmployeeRegisterDAO getINSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new EmployeeRegisterDAO();
		}
		return INSTANCE;
	}
	public void salvarDados(EmployeeRegisterModel employee) throws Exception{
		try {
			connectionFactory = ConnectionFactory.getINSTANCE();
			sql = "INSERT INTO funcionario (cpf,nome,funcao,email,senha)VALUES (?,?,?,?,?)";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, employee.getCpf());
			stmt.setString(2, employee.getNome());
			stmt.setString(3, employee.getFuncao());
			stmt.setString(4, employee.getEmail());
			stmt.setString(5, employee.getSenha());
			stmt.executeUpdate();
		} finally {
			connectionFactory.closeConnection(con, stmt);
		}
	}

}
