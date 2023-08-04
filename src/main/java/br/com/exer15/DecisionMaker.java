package br.com.exer15;

public class DecisionMaker {
	public boolean mostrarAnuncio(Usuario u, boolean anuncioRelevante) {
		if (u.isInativoPor2Semanas()) {
			return false;
		}

		if (u.isViuAnuncioUltimaHora()) {
			return false;
		}

		if (u.getNumeroDeSeguidores() > 1000) {
			return anuncioRelevante;
		}
		return true;
	}
}
