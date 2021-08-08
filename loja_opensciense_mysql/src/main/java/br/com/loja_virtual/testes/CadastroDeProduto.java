package br.com.loja_virtual.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja_virtual.dao.CategoriaDAO;
import br.com.loja_virtual.dao.ProdutoDAO;
import br.com.loja_virtual.modelo.Categoria;
import br.com.loja_virtual.modelo.Produto;
import br.com.loja_virtual.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);

		Produto p = produtoDAO.buscarPorId(1l);
		System.out.println(p.getPreco());

		List<Produto> todos = produtoDAO.buscarPorNomeDaCategoria("celulares");
		todos.forEach(p2 -> System.out.println(p2.getNome()));
		
		BigDecimal precoDoProduto = produtoDAO.buscarPrecoDoProdutoComNome("iPhone");
		System.out.println("Preco do Produto: " + precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("celulares");
		Produto celular = new Produto("iPhone 12 Pro Max", "250GB de Amazenamento", new BigDecimal("10000"), celulares);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);

		em.getTransaction().begin();

		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);

		em.getTransaction().commit();
		em.close();
	}
}
