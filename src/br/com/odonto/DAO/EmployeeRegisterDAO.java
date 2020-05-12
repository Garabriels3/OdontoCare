package br.com.odonto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.odonto.model.EmployeeRegisterModel;
import br.com.odonto.util.ConnectionFactory;

public class EmployeeRegisterDAO {
	private static EmployeeRegisterDAO INSTANCE;
	private final ConnectionFactory connectionFactory = ConnectionFactory.getINSTANCE();
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
	public void salvarDados(EmployeeRegisterModel funcionario) throws Exception{
		try {
			sql = "INSERT INTO funcionario (cpf,nome,funcao,email,senha)VALUES (?,?,?,?,?)";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, funcionario.getCpf());
			stmt.setString(2, funcionario.getNome());
			stmt.setString(3, funcionario.getFuncao());
			stmt.setString(4, funcionario.getEmail());
			stmt.setString(5, funcionario.getSenha());
			stmt.executeUpdate();
		} finally {
			connectionFactory.closeConnection(con, stmt);
		}
	}
	public boolean verificarLogin(String senha, String email) throws Exception{
		try {
			boolean check = false;
			sql = "SELECT * FROM funcionario WHERE senha = ? and email = ?";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, senha);
			stmt.setString(2, email);
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
