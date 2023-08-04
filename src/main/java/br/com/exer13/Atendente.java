package br.com.exer13;

public class Atendente {
	private ProdutoDAO produtoDAO;

	public Atendente(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	public String efetuarPedidoDeOrcamento(String codigoDeBarras, int quantidade)
			throws IllegalArgumentException, SemEstoqueException {
		if (!isValidBarcode(codigoDeBarras)) {
			throw new IllegalArgumentException("codigo de barras invalido");
		}

		if (!isValidQuantity(quantidade)) {
			throw new IllegalArgumentException("quantidade invalida");
		}

		int estoque = produtoDAO.getQuantidadeDisponivel(codigoDeBarras);
		if (quantidade > estoque) {
			throw new SemEstoqueException();
		}

		if (quantidade < estoque / 2) {
			return "Orcamento normal";
		} else {
			return "Orcamento variavel";
		}
	}

	private boolean isValidBarcode(String codigoDeBarras) {
		return codigoDeBarras.matches("\\d{13}");
	}

	private boolean isValidQuantity(int quantidade) {
		return quantidade >= 1 && quantidade <= 1000;
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

}