package br.com.odonto.model;

public class LoginModel {
	private String login;
	private String senha;
	
	
	public LoginModel(String login, String password) {
		this.setEmail(login);
		this.setPassword(password);
	}
	
	public String getEmail() {
		return login;
	}

	public void setEmail(String login) {
		this.login = login;
	}

	public String getPassword() {
		return senha;
	}

	public void setPassword(String password) {
		this.senha = password;
	}
}
