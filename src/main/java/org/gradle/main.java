package org.gradle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.gradle.entities.Pelicula;

public class main {

	public static void main(String[] args) {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
			EntityManager manager = emf.createEntityManager();
			manager.getTransaction().begin();
			
			manager.getTransaction().commit();
	}

}
