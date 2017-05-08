package br.com.fiap.bo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.engine.AxisError;
import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.dao.impl.JogoDAOImpl;
import br.com.fiap.entity.Produto;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class ProdutoBO {

	private EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
	
	public void cadastrar(Produto produto) throws AxisFault{
		EntityManager em = fabrica.createEntityManager();
		ProdutoDAO dao = new ProdutoDAOImpl(em);
		try {
			dao.cadastrar(produto);
			dao.salvar(); //commit
		} catch (DBException e) {
			e.printStackTrace();
			throw new AxisFault("Cadastro não realizado");
		} finally {
			em.close();
		}
	}
	
	public Produto buscar(int id){
		EntityManager em = fabrica.createEntityManager();
		ProdutoDAO dao = new ProdutoDAOImpl(em);
		Produto produto = dao.pesquisar(id);
		em.close();
		return jogo;
	}
	
	//Atualizar e Remover
	public void atualizar(Produto produto) throws AxisFault {
		EntityManager em = fabrica.createEntityManager();
		ProdutoDAO dao = new ProdutoDAOImpl(em);
		try {
			dao.alterar(jogo);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			throw new AxisError("Erro ao atualizar");
		}finally {
			em.close();
		}
	}
	
	public void remover(int id) throws AxisFault {
		EntityManager em = fabrica.createEntityManager();
		Produto dao = new ProdutoDAOImpl(em);
		try {
			dao.remover(id);
			dao.salvar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AxisError("Erro ao remover");
		} finally {
			em.close();
		}
	}
	
}