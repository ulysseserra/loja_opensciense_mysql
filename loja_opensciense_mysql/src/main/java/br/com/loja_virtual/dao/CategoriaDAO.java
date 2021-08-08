package br.com.loja_virtual.dao;

import javax.persistence.EntityManager;

import br.com.loja_virtual.modelo.Categoria;

public class CategoriaDAO {

	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
}
