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
	public boolean saveConsultationData(SchedulingModel scheduling)throws Exception{
		try {
			boolean success = false;
			connectionFactory = new ConnectionFactory();
			sql = "INSERT INTO agendamento (cpf_cliente,duracaoConsulta,dentista,dataConsulta,horarioConsulta,motivo) VALUES (?,?,?,?,?,?)";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,scheduling.getCpf());
			stmt.setString(2,scheduling.getDuration());
			stmt.setString(3,scheduling.getDentist());
			stmt.setString(4,scheduling.getDate());
			stmt.setString(5,scheduling.getSchedule());
			stmt.setString(6,scheduling.getReason());
			int i = stmt.executeUpdate();
			if( i > 0) {
				success = true;
			}			
			return success;
		} finally {
			connectionFactory.closeConnection(con, stmt);
		}
	}
	public SchedulingModel querySchedulingData(String cpf, String date)throws Exception {
		try {
			connectionFactory = new ConnectionFactory();
			sql = "SELECT * FROM agendamento WHERE cpf_cliente=? and dataConsulta=?";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.setString(2, date);
			rs = stmt.executeQuery();
			if(rs.first()) {
				String duration = rs.getString("duracaoConsulta");
				String schedule = rs.getString("horarioConsulta");
				String dentist = rs.getString("dentista");
				String reason = rs.getString("motivo");
				scheduling = new SchedulingModel(cpf, duration, schedule, date, dentist, reason);
			}	
			return scheduling;
		} finally {
			connectionFactory.closeConnection(con, stmt, rs);
		}
	}
	public boolean updateConsultationData(SchedulingModel scheduling)throws Exception{
		try {
			boolean success = false;
			connectionFactory = new ConnectionFactory();
			sql = "UPDATE agendamento SET duracaoConsulta=?,dentista=?,dataConsulta=?,horarioConsulta=?,motivo=? WHERE cpf_cliente=?";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,scheduling.getDuration());
			stmt.setString(2,scheduling.getDentist());
			stmt.setString(3,scheduling.getDate());
			stmt.setString(4,scheduling.getSchedule());
			stmt.setString(5,scheduling.getReason());
			stmt.setString(6,scheduling.getCpf());
			int i = stmt.executeUpdate();
			if( i > 0) {
				success = true;
			}			
			return success;
		} finally {
			connectionFactory.closeConnection(con, stmt);
		}
	}
	public boolean excludeConsultation(String cpf, String date)throws Exception{
		try {
			boolean success = false;
			connectionFactory = new ConnectionFactory();
			sql = "DELETE FROM agendamento WHERE cpf_cliente=? and dataConsulta=?";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,cpf);
			stmt.setString(2,date);
			int i = stmt.executeUpdate();
			if(i > 0) {
				success = true;
			}
			return success;
		} finally {
			connectionFactory.closeConnection(con, stmt);
		}
	}
}
