package br.com.odonto.model;

public class ClientRegisterModel {
	private String cpf;
	private String name;
	private String phone;
	private String birthday;
	private String sex;
	private String cep;
	private String street;
	private String neighborhood;
	private String city;
	private String state;
	
	public ClientRegisterModel() {
		
	}

	public ClientRegisterModel(String cpf, String name, String phone, String birthday, String sex, String cep,
			String street, String neighborhood, String city, String state) {
		this.cpf = cpf;
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
		this.sex = sex;
		this.cep = cep;
		this.street = street;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
