package br.com.exer12;

public class MontanhaRussaControlador {
	ClienteDao clienteDao;

	public MontanhaRussaControlador(ClienteDao pClienteDao) {
		clienteDao = pClienteDao;
	}

	public String autorizar(String nome, int idade) throws Exception {
		if (!isValidName(nome)) {
			throw new IllegalArgumentException("nome inválido");
		}

		if (!isValidAge(idade)) {
			throw new IllegalArgumentException("idade inválida");
		}

		if (idade >= 18 && idade <= 90) {
			return "autorizado";
		} else if (idade < 18) {
			return "acompanhado dos pais";
		} else {
			return "acompanhado do responsavel legal";
		}
	}

	private boolean isValidName(String nome) {
		String[] words = nome.split(" ");
		if (words.length < 2) {
			return false;
		}

		for (String word : words) {
			if (!word.matches("[A-Za-z]+")) {
				return false;
			}
		}

		return true;
	}

	private boolean isValidAge(int idade) {
		return idade >= 1 && idade <= 120;
	}
}