package br.com.odonto.controller;

import javax.swing.JOptionPane;

import br.com.odonto.DAO.ClientRegisterDao;
import br.com.odonto.model.CepModel;
import br.com.odonto.service.CepApi;

public class ClientRegisterController {
	ClientRegisterDao registerDao = new ClientRegisterDao(); // instancia da DAO
	CepModel data; // Variavel para pegar o retorno da fun��o da DAO
	
	public CepModel getAdress(String path) {
		if(path != null) { // Checamos aqui, se o path, que � o nosso CEP, n�o est� vazio, o que poderia ocasionar um Crash na Service, caso n�o verificado
			data = registerDao.getApi(path);
		}else {
			JOptionPane.showInternalMessageDialog(null, "Campo Cep n�o preenchido"); // caso esteja vazio, essa camada � responsavel, por avisar o usuario, e n�o deixar prosseguir para proxima camada
		}
		return data; // Retorna os Dados da API convertidos para View
	}
}
