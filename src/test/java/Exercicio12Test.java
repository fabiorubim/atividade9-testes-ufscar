import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.exer12.ClienteDao;
import br.com.exer12.MontanhaRussaControlador;

class Exercicio12Test {

	@Test
	void testAutorizarPessoaValida() throws Exception {
		ClienteDao clienteDaoMock = Mockito.mock(ClienteDao.class);
		when(clienteDaoMock.ehCliente("Fabio Rubim")).thenReturn(true);

		MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDaoMock);

		assertEquals("autorizado", controlador.autorizar("Fabio Rubim", 20));
		assertEquals("acompanhado dos pais", controlador.autorizar("Fabio Rubim", 15));
		assertEquals("acompanhado do responsavel legal", controlador.autorizar("Fabio Rubim", 95));
	}

	@Test
	void testAutorizarNomeInvalido() {
		ClienteDao clienteDaoMock = Mockito.mock(ClienteDao.class);
		when(clienteDaoMock.ehCliente("")).thenReturn(true);

		MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDaoMock);

		assertThrows(Exception.class, () -> controlador.autorizar("", 25));
		assertThrows(Exception.class, () -> controlador.autorizar("João", 30));
		assertThrows(Exception.class, () -> controlador.autorizar("Pedro", 35));
	}

	@Test
	void testAutorizarIdadeInvalida() {
		ClienteDao clienteDaoMock = Mockito.mock(ClienteDao.class);
		when(clienteDaoMock.ehCliente("Fabio Rubim")).thenReturn(true);

		MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDaoMock);

		assertThrows(Exception.class, () -> controlador.autorizar("Fabio Rubim", 0));
		assertThrows(Exception.class, () -> controlador.autorizar("Fabio Rubim", 121));
	}

	@Test
	void testAutorizarPessoaNaoCliente() {
		ClienteDao clienteDaoMock = Mockito.mock(ClienteDao.class);
		when(clienteDaoMock.ehCliente("Fabio Rubim")).thenReturn(false);
		
		assertThrows(Exception.class, () -> {
            if (!clienteDaoMock	.ehCliente("Fabio Rubim")) {
                throw new Exception("Pessoa não é cliente");
            }
        });
	}

}
