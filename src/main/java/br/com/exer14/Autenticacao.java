package br.com.exer14;

public class Autenticacao {
	public String login(Usuario usuario) {
		String email = usuario.getEmail();
		String senha = usuario.getSenha();
		String tipo = usuario.getTipo();

		if (email.isEmpty() || senha.isEmpty()) {
			return "e-mail/senha não podem ser vazio.";
		}

		if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")) {
			return "e-mail fora do formato.";
		}

		if (senha.length() < 4) {
			return "a senha tem ao menos 4 caracteres.";
		}

		if (email.equals("admin@admin.com")) {
			if (senha.equals("admin")) {
				return "logado como admin";
			} else {
				return "senha incorreta";
			}
		} else if (email.equals("user@user.com")) {
			if (senha.equals("userpass")) {
				return tipo.equals("admin") ? "logado como admin" : "logado";
			} else {
				return "senha incorreta";
			}
		} else {
			return "usuario não existe";
		}
	}
}