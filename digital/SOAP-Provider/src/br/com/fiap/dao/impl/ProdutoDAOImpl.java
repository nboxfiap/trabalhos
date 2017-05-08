package br.com.fiap.dao.impl;

import br.com.fiap.entity.Produto;
import javax.persistence.EntityManager;
import br.com.fiap.dao.ProdutoDAO;

public class ProdutoDAOImpl 
				extends GenericDAOImpl<Produto, Integer> 
										implements ProdutoDAO{

	public ProdutoDAOImpl(EntityManager em) {
		super(em);
	}

}