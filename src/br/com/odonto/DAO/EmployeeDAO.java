package br.com.odonto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.odonto.model.EmployeeModel;
import br.com.odonto.util.ConnectionFactory;

public class EmployeeDAO {
	private ConnectionFactory connectionFactory;
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String sql = null;
	boolean success;
	
	public EmployeeDAO() {	
	}
	
	public boolean salvarDados(EmployeeModel employee) throws Exception{
		try {
			connectionFactory = new ConnectionFactory();

			sql = "INSERT INTO funcionario (cpf_func,nome_func,funcao,email_func,senha_func) VALUES (?,?,?,?,?)";
				con = connectionFactory.getConnection();
				stmt = con.prepareStatement(sql);
				stmt.setString(1, employee.getCpf());
				stmt.setString(2, employee.getName());
				stmt.setString(3, employee.getOccupation());
				stmt.setString(4, employee.getEmail());
				stmt.setString(5, employee.getPassword());
				int i = stmt.executeUpdate();
				if( i > 0) {
					success = true;
				}			
				return success;
		} finally {
			connectionFactory.closeConnection(con, stmt);
		}
	}

}
