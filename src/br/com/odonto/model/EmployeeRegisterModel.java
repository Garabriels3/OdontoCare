package br.com.odonto.model;

public class EmployeeRegisterModel {
	private String cpf;
	private String nome;
	private String funcao;
	private String email;
	private String senha;
	
	public EmployeeRegisterModel() {
		
	}
	public EmployeeRegisterModel(String cpf, String nome, String funcao, String email, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.funcao = funcao;
		this.email = email;
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
