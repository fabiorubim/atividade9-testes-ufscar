package br.com.exer14;

public class Usuario {
	private String email, senha, tipo;

	public Usuario(String email, String senha, String tipo) {
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getTipo() {
		return tipo;
	}
}