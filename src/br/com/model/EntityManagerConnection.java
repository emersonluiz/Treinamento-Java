package br.com.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerConnection {
	
	public static EntityManager getEntityManager(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
		EntityManager em = emf.createEntityManager();
		return em;
		
	}

}
