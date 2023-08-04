package br.com.exer15;

public class Usuario {
	private int numeroDeSeguidores;
	boolean inativoPor2Semanas;
	boolean viuAnuncioUltimaHora;

	public Usuario(int seguidores, boolean inativo, boolean viuAnuncio) {
		this.numeroDeSeguidores = seguidores;
		this.inativoPor2Semanas = inativo;
		this.viuAnuncioUltimaHora = viuAnuncio;
	}

	public int getNumeroDeSeguidores() {
		return numeroDeSeguidores;
	}

	public boolean isInativoPor2Semanas() {
		return inativoPor2Semanas;
	}

	public boolean isViuAnuncioUltimaHora() {
		return viuAnuncioUltimaHora;
	}
}