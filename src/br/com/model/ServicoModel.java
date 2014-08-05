package br.com.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.bean.Servico;
import br.com.dao.Persistence;

public class ServicoModel implements Persistence<Servico>{

private EntityManager em;
	
	public ServicoModel(EntityManager em){
		this.em = em;
	}

	@Override
	public Servico insert(Servico element) {
		em.getTransaction().begin();
		em.persist(element);
		em.getTransaction().commit();
		return element;
	}

	@Override
	public Servico update(Servico element) {
		em.getTransaction().begin();
		em.merge(element);
		em.getTransaction().commit();
		return element;
	}

	@Override
	public Servico delete(int id) {
		Servico servico = get(id);
		em.getTransaction().begin();
		em.remove(servico);
		em.getTransaction().commit();
		return servico;
	}

	@Override
	public Servico get(int id) {
		Servico servico = em.find(Servico.class, id);
		return servico;
	}

	@Override
	public List<Servico> getAll() {
		Query query = em.createQuery("FROM Servico");
		@SuppressWarnings("unchecked")
		List<Servico> list = query.getResultList();
		return list;
	}
	
}
