package org.gradle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class main {

	public static void main(String[] args) {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
			EntityManager manager = emf.createEntityManager();
			manager.getTransaction().begin();
			
			Query query = manager.createNativeQuery(""
					+ "SELECT peli.id_pelicula, peli.nombre FROM Pelicula as peli "
					+ "INNER JOIN Personaje as pe "
					+ "ON peli.id_pelicula = pe.id_pelicula "
					+ "WHERE peli.id_pelicula =:id GROUP BY peli.id_pelicula ");
			query.setParameter("id", 1);
			System.out.println(query.getResultList().get(0));
			
			
	}
}
