package br.com.model;

import javax.persistence.EntityManager;

import br.com.bean.NomeacaoServico;
import br.com.dao.PersistenceDelete;

public class NomeacaoServicoModel implements PersistenceDelete<NomeacaoServico>{

private EntityManager em;
	
	public NomeacaoServicoModel(EntityManager em){
		this.em = em;
	}
	
	@Override
	public NomeacaoServico delete(int id) {
		NomeacaoServico ns = em.find(NomeacaoServico.class, id);
		em.getTransaction().begin();
		em.remove(ns);
		em.getTransaction().commit();
		return ns;
	}

}
