package br.com.odonto.model;

public class ClientRegisterModel {
	private String cpf;
	private String name;
	private String cellphone;
	private String birthday;
	private String sex;
	private String cep;
	private String loradouro;
	private String bairro;
	private String cidade;
	private String estado;
	
	public ClientRegisterModel() {
		
	}

	public ClientRegisterModel(String cpf, String name, String cellphone, String birthday, String sex, String cep,
			String loradouro, String bairro, String cidade, String estado) {
		this.cpf = cpf;
		this.name = name;
		this.cellphone = cellphone;
		this.birthday = birthday;
		this.sex = sex;
		this.cep = cep;
		this.loradouro = loradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLoradouro() {
		return loradouro;
	}

	public void setLoradouro(String loradouro) {
		this.loradouro = loradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
