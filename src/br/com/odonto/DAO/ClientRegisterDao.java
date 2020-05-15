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
import br.com.odonto.model.ClientRegisterModel;
import br.com.odonto.service.CepApi;
import br.com.odonto.util.ConnectionFactory;

public class ClientRegisterDao {
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
	boolean check;
	
	public CepModel convertApi(String path) {
		instance = CepApi.getInstance(); // Usamos a instancia do Singleton, para instanciar a classe, de forma Unica
		json = instance.doRequest(path); // Aqui atribuimos a variavel json, o retorno de doRequest, que retornará o JSON puro sem conversão
		type = new TypeToken<CepModel>() {}.getType(); // Aqui fazemos um TypeToken, do tipo Generico CepModel
		
			data = gson.fromJson(json, type); // Inicializamos a var data com os dados vindos da API de forma Convertida, para Objeto, para que possamos acessar
		
		return data; // retorna os dados da API, agora já convertidos objetos manipulaveis dentro da linguagem Java
	}
	public boolean saveClientData(ClientRegisterModel client)throws Exception {
		try {
			connectionFactory = new ConnectionFactory();

			sql = "INSERT INTO cliente (cpf_cliente,nome_cliente,cel_cliente,dataNascimento,sexo,cep,logradouro,bairro,cidade,estado) VALUES (?,?,?,?,?,?,?,?,?,?)";
				con = connectionFactory.getConnection();
				stmt = con.prepareStatement(sql);
				stmt.setString(1,client.getCep());
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
					check = true;
				}			
				return check;
		} finally {
			connectionFactory.closeConnection(con, stmt);
		}
		
	}

}


