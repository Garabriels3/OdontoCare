package br.com.odonto.model;

public class EmployeeRegisterModel {
	private String cpf;
	private String name;
	private String occupation;
	private String email;
	private String password;
	
	public EmployeeRegisterModel() {
		
	}
	public EmployeeRegisterModel(String cpf, String name, String occupation, String email, String password) {
		this.cpf = cpf;
		this.name = name;
		this.occupation = occupation;
		this.email = email;
		this.password = password;
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
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
