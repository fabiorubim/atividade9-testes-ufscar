import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.exer13.Atendente;
import br.com.exer13.ProdutoDAO;
import br.com.exer13.SemEstoqueException;

class Exercicio13Test {

	@Test
	void testEfetuarPedidoDeOrcamentoNormal() throws Exception {
		ProdutoDAO produtoDaoMock = Mockito.mock(ProdutoDAO.class);
		when(produtoDaoMock.getQuantidadeDisponivel("1234567890123")).thenReturn(100);

		Atendente atendente = new Atendente(produtoDaoMock);

		assertEquals("Orcamento normal", atendente.efetuarPedidoDeOrcamento("1234567890123", 49));
	}

	@Test
	void testEfetuarPedidoDeOrcamentoVariavel() throws Exception {
		ProdutoDAO produtoDaoMock = Mockito.mock(ProdutoDAO.class);
		when(produtoDaoMock.getQuantidadeDisponivel("9876543210987")).thenReturn(100);

		Atendente atendente = new Atendente(produtoDaoMock);

		assertEquals("Orcamento variavel", atendente.efetuarPedidoDeOrcamento("9876543210987", 50));
	}

	@Test
	void testEfetuarPedidoDeOrcamentoQuantidadeInvalida() {
		ProdutoDAO produtoDaoMock = Mockito.mock(ProdutoDAO.class);
		when(produtoDaoMock.getQuantidadeDisponivel("1112223334445")).thenReturn(1000);

		Atendente atendente = new Atendente(produtoDaoMock);

		assertThrows(IllegalArgumentException.class, () -> atendente.efetuarPedidoDeOrcamento("1112223334445", 0));
		assertThrows(IllegalArgumentException.class, () -> atendente.efetuarPedidoDeOrcamento("1112223334445", 1001));
	}

	@Test
	void testEfetuarPedidoDeOrcamentoCodigoInvalido() {
		ProdutoDAO produtoDaoMock = Mockito.mock(ProdutoDAO.class);
		when(produtoDaoMock.getQuantidadeDisponivel("ABCDE12345")).thenReturn(500);

		Atendente atendente = new Atendente(produtoDaoMock);

		assertThrows(IllegalArgumentException.class, () -> atendente.efetuarPedidoDeOrcamento("ABCDE12345", 100));
		assertThrows(IllegalArgumentException.class, () -> atendente.efetuarPedidoDeOrcamento("12345", 500));
		assertThrows(IllegalArgumentException.class, () -> atendente.efetuarPedidoDeOrcamento("123456789012345", 200));
	}

	@Test
	void testEfetuarPedidoDeOrcamentoSemEstoque() {
		ProdutoDAO produtoDaoMock = Mockito.mock(ProdutoDAO.class);
		when(produtoDaoMock.getQuantidadeDisponivel("7777777777777")).thenReturn(10);

		Atendente atendente = new Atendente(produtoDaoMock);

		assertThrows(SemEstoqueException.class, () -> atendente.efetuarPedidoDeOrcamento("7777777777777", 20));
	}

}
