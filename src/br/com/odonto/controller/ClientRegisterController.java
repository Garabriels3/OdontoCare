package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.ClientRegisterDao;
import br.com.odonto.model.CepModel;
import br.com.odonto.service.CepApi;

public class ClientRegisterController {
	ClientRegisterDao registerDao = new ClientRegisterDao(); // instancia da DAO
	CepModel data; // Variavel para pegar o retorno da função da DAO
	
	public CepModel getAdress(String path) {
		if(path != null && path.length() == 8) { // Checamos aqui, se o path, que é o nosso CEP, não está vazio, o que poderia ocasionar um Crash na Service, caso não verificado
			data = registerDao.convertApi(path);
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
}
