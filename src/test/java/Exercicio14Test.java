import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import br.com.exer14.Autenticacao;
import br.com.exer14.Usuario;

class Exercicio14Test {

	@Test
	void testLoginUsuarioNaoExiste() {
		Usuario usuarioMock = mock(Usuario.class);
		when(usuarioMock.getEmail()).thenReturn("nao_existe@gmail.com");
		when(usuarioMock.getSenha()).thenReturn("senha123");
		when(usuarioMock.getTipo()).thenReturn("normal");

		Autenticacao autenticacao = new Autenticacao();

		String resultado = autenticacao.login(usuarioMock);

		assertEquals("usuario não existe", resultado);
	}

	@Test
	void testLoginSenhaIncorreta() {
		Usuario usuarioMock = mock(Usuario.class);
		when(usuarioMock.getEmail()).thenReturn("admin@admin.com");
		when(usuarioMock.getSenha()).thenReturn("senha123");
		when(usuarioMock.getTipo()).thenReturn("normal");

		Autenticacao autenticacao = new Autenticacao();

		String resultado = autenticacao.login(usuarioMock);

		assertEquals("senha incorreta", resultado);
	}

	@Test
	void testLoginLogadoAdmin() {
		Usuario usuarioMock = mock(Usuario.class);
		when(usuarioMock.getEmail()).thenReturn("admin@admin.com");
		when(usuarioMock.getSenha()).thenReturn("admin");
		when(usuarioMock.getTipo()).thenReturn("admin");

		Autenticacao autenticacao = new Autenticacao();

		String resultado = autenticacao.login(usuarioMock);

		assertEquals("logado como admin", resultado);
	}

	@Test
	void testLoginLogadoNormal() {
		Usuario usuarioMock = mock(Usuario.class);
		when(usuarioMock.getEmail()).thenReturn("user@user.com");
		when(usuarioMock.getSenha()).thenReturn("userpass");
		when(usuarioMock.getTipo()).thenReturn("logado");

		Autenticacao autenticacao = new Autenticacao();

		String resultado = autenticacao.login(usuarioMock);

		assertEquals("logado", resultado);
	}

}
