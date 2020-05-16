package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.ClientDAO;
import br.com.odonto.model.CepModel;
import br.com.odonto.model.ClientModel;
import br.com.odonto.service.CepApi;

public class ClientController {
	ClientModel client;
	ClientDAO clientDAO = new ClientDAO(); // instancia da DAO
	CepModel data; // Variavel para pegar o retorno da função da DAO

	public CepModel getAdress(String path) {
		if(path != null && path.length() == 8) { // Checamos aqui, se o path, que é o nosso CEP, não está vazio, o que poderia ocasionar um Crash na Service, caso não verificado
			data = clientDAO.convertApi(path);
		}else {
			JOptionPane.showInternalMessageDialog(null, "Campo Cep não preenchido corretamente"); // caso esteja vazio, essa camada é responsavel, por avisar o usuario, e não deixar prosseguir para proxima camada
		}
		if(data != null) {
			return data; // Retorna os Dados da API convertidos para View
		}else {
			JOptionPane.showInternalMessageDialog(null, "Campo Cep não encontrado");
			return null;
		}
		
	}

	public boolean saveClientData(String cpf, String name, String phone, String birthday, String sex,String cep,
			String street, String neighborhood, String city, String state)throws Exception {	
		boolean success = false;
		if(cpf.length() > 0 && name.length() > 0 && phone.length() > 0 && sex.length() > 0 && cep.length() > 0 &&
				street.length() > 0 && neighborhood.length() > 0 && city.length() > 0 && state.length() > 0) {		
			client = new ClientModel(cpf, name, phone, birthday, sex, cep, street, neighborhood, city, state);
			success = clientDAO.saveClientData(client);
		}
		return success;
	}
	public ClientModel queryClientData(String cpf) throws Exception{
		if(cpf.length() > 10){
			return clientDAO.queryClientData(cpf);
		}
		return null;	
	}
	public boolean updateClientData(String cpf, String name, String phone, String birthday, String sex,String cep,
			String street, String neighborhood, String city, String state)throws Exception {	
		boolean success = false;
		if(cpf.length() > 0 && name.length() > 0 && phone.length() > 0 && sex.length() > 0 && cep.length() > 0 &&
				street.length() > 0 && neighborhood.length() > 0 && city.length() > 0 && state.length() > 0) {		
			client = new ClientModel(cpf, name, phone, birthday, sex, cep, street, neighborhood, city, state);
			success = clientDAO.updateClientData(client);
		}
		return success;
	}
	public boolean excludeClientData(String cpf)throws Exception{
		boolean success = false;
		if(cpf.length() > 10) {
			success = clientDAO.excludeClientData(cpf);
		}
		return success;
	}

}






