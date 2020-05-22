package br.com.odonto.DAO;

import java.awt.List;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.odonto.model.CepModel;
import br.com.odonto.model.ClientModel;
import br.com.odonto.service.CepApi;
import br.com.odonto.util.ConnectionFactory;

//AUTHOR: Gabriel Dos Santos Nascimento(21285136) e Felipe Pereira dos Santos(21192057) 

public class ClientDAO {
	private Gson gson = new GsonBuilder().create(); // Gson é uma library, que converte Json para Objeto manipulavel, ou de Obejto para Json (fromJson, toJson)
    private CepModel data; // Variavel do tipo da Model, para manipular a api através de objetos Java
	private String json;
	private Type type;
	private CepApi instance;
	private ConnectionFactory connectionFactory;
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String sql = null;
	private ClientModel client;
	
	public CepModel convertApi(String path) {
		instance = CepApi.getInstance(); // Usamos a instancia do Singleton, para instanciar a classe, de forma Unica
		json = instance.doRequest(path); // Aqui atribuimos a variavel json, o retorno de doRequest, que retornará o JSON puro sem conversão
		type = new TypeToken<CepModel>() {}.getType(); // Aqui fazemos um TypeToken, do tipo Generico CepModel
		
			data = gson.fromJson(json, type); // Inicializamos a var data com os dados vindos da API de forma Convertida, para Objeto, para que possamos acessar
		
		return data; // retorna os dados da API, agora já convertidos objetos manipulaveis dentro da linguagem Java
	}
	public boolean saveClientData(ClientModel client)throws Exception {
		try {
			boolean success = false;
			connectionFactory = new ConnectionFactory();
			sql = "INSERT INTO cliente (cpf_cliente,nome_cliente,cel_cliente,dataNascimento,sexo,cep,logradouro,bairro,cidade,estado) VALUES (?,?,?,?,?,?,?,?,?,?)";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,client.getCpf());
			stmt.setString(2,client.getName());
			stmt.setString(3,client.getPhone());
			stmt.setString(4,client.getBirthday());
			stmt.setString(5,client.getSex());
			stmt.setString(6,client.getCep());
			stmt.setString(7,client.getStreet());
			stmt.setString(8,client.getNeighborhood());
			stmt.setString(9,client.getCity());
			stmt.setString(10,client.getState());
			int i = stmt.executeUpdate();
			if( i > 0) {
				success = true;
			}			
			return success;
		} finally {
			connectionFactory.closeConnection(con, stmt);
		}
		
	}
	public ClientModel queryClientData(String cpf)throws Exception{
		try {
			connectionFactory = new ConnectionFactory();
			sql = "SELECT * FROM cliente WHERE cpf_cliente = ?";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			rs = stmt.executeQuery();
			if(rs.first()) {
				String name = rs.getString("nome_cliente");
				String phone = rs.getString("cel_cliente");
				String birthday = rs.getString("dataNascimento");
				String sex = rs.getString("sexo");
				String cep = rs.getString("cep");
				String street = rs.getString("logradouro");
				String neighborhood = rs.getString("bairro");
				String city = rs.getString("cidade");
				String state = rs.getString("estado");
				client = new ClientModel(cpf, name, phone, birthday, sex, cep, street, neighborhood, city, state);
			}	
			return client;
		} finally {
			connectionFactory.closeConnection(con, stmt, rs);
		}
	}
	public boolean updateClientData(ClientModel client)throws Exception{
		boolean success = false;
		connectionFactory = new ConnectionFactory();
		sql = "UPDATE cliente SET nome_cliente=?,cel_cliente=?,dataNascimento=?,sexo=?,"
				+ "cep=?,logradouro=?,bairro=?,cidade=?,estado=? WHERE cpf_cliente = ?";
		con = connectionFactory.getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1,client.getName());
		stmt.setString(2,client.getPhone());
		stmt.setString(3,client.getBirthday());
		stmt.setString(4,client.getSex());
		stmt.setString(5,client.getCep());
		stmt.setString(6,client.getStreet());
		stmt.setString(7,client.getNeighborhood());
		stmt.setString(8,client.getCity());
		stmt.setString(9,client.getState());
		stmt.setString(10,client.getCpf());
		int i = stmt.executeUpdate();
		if( i > 0) {
			success = true;
		}			
		return success;
	}
	public boolean excludeClientData(String cpf)throws Exception{
		try {
			boolean success = false;
			connectionFactory = new ConnectionFactory();
			sql = "DELETE FROM cliente WHERE cpf_cliente=?";
			con = connectionFactory.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,cpf);
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


