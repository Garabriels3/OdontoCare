package br.com.odonto.model;

public class LoginModel {
<<<<<<< HEAD
	private String login;
	private String password;
=======
	private String senha;
	private String email;
>>>>>>> origin/FuncionarioCRUD
	
	public LoginModel() {
	}

	public LoginModel(String senha, String email) {
		this.senha = senha;
		this.email = email;
	}

<<<<<<< HEAD
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
=======
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
>>>>>>> origin/FuncionarioCRUD
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
