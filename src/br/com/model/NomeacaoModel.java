package br.com.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.bean.Nomeacao;
import br.com.dao.Persistence;

public class NomeacaoModel implements Persistence<Nomeacao> {
	
private EntityManager em;
	
	public NomeacaoModel(EntityManager em){
		this.em = em;
	}

	@Override
	public Nomeacao insert(Nomeacao element) {
		em.getTransaction().begin();
		em.persist(element);
		em.getTransaction().commit();
		return element;
	}

	@Override
	public Nomeacao update(Nomeacao element) {
		em.getTransaction().begin();
		em.merge(element);
		em.getTransaction().commit();
		return element;
	}

	@Override
	public Nomeacao delete(int id) {
		Nomeacao Nomeacao = get(id);
		em.getTransaction().begin();
		em.remove(Nomeacao);
		em.getTransaction().commit();
		return Nomeacao;
	}

	@Override
	public Nomeacao get(int id) {
		Nomeacao Nomeacao = em.find(Nomeacao.class, id);
		return Nomeacao;
	}

	@Override
	public List<Nomeacao> getAll() {
		Query query = em.createQuery("FROM Nomeacao");
		@SuppressWarnings("unchecked")
		List<Nomeacao> list = query.getResultList();
		return list;
	}

}
