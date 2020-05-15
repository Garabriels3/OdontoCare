package br.com.odonto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.odonto.model.ClientModel;
import br.com.odonto.model.SchedulingModel;
import br.com.odonto.util.ConnectionFactory;

public class SchedulingDAO {
	private SchedulingModel scheduling;
	private ConnectionFactory connectionFactory;
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String sql = null;
	boolean success;
	
	public String queryClientName(String cpf)throws Exception{
		try {
			String name = null;
			connectionFactory = new ConnectionFactory();
			sql = "SELECT nome_cliente FROM cliente WHERE cpf_cliente = ?";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
			if(rs.first()) {
				name = rs.getString("nome_cliente");
			}	
			return name;
		} finally {
			connectionFactory.closeConnection(con, stmt, rs);
		}
	}
}
