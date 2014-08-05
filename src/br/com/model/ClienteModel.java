package br.com.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.bean.Cliente;
import br.com.dao.Persistence;

public class ClienteModel implements Persistence<Cliente> {
	
	private EntityManager em;
	
	public ClienteModel(EntityManager em){
		this.em = em;
	}

	@Override
	public Cliente insert(Cliente element) {
		em.getTransaction().begin();
		em.persist(element);
		em.getTransaction().commit();
		return element;
	}

	@Override
	public Cliente update(Cliente element) {
		em.getTransaction().begin();
		em.merge(element);
		em.getTransaction().commit();
		return element;
	}

	@Override
	public Cliente delete(int id) {
		Cliente cliente = get(id);
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		return cliente;
	}

	@Override
	public Cliente get(int id) {
		Cliente cliente = em.find(Cliente.class, id);
		return cliente;
	}

	@Override
	public List<Cliente> getAll() {
		Query query = em.createQuery("FROM Cliente");
		@SuppressWarnings("unchecked")
		List<Cliente> list = query.getResultList();
		return list;
	}

}
