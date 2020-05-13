package br.com.odonto.model;

public class LoginModel {
	private String senha;
	private String email;
	
	public LoginModel() {
	}

	public LoginModel(String senha, String email) {
		this.senha = senha;
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
