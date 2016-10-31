package org.gradle.services;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gradle.Respuesta;
import org.gradle.entities.Pelicula;

@Path("/peliculas")
public class Peliculas {
	
	EntityManagerFactory emf;
	EntityManager manager;
	
	@POST
    @Path("/peliculas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pelicula> peliculas() throws SQLException {
		emf = Persistence.createEntityManagerFactory("persistencia");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		
		//validacion no hallan mismos usuarios
		Query query = manager.createQuery("FROM Pelicula");
		System.out.println(query.getResultList().size());
		if (query.getResultList().size() < 1 ){
			return null;
		}else{
			return query.getResultList();
		}
	}
	
	@POST
    @Path("/pelicula/{filtro}/{texto}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pelicula> login(@PathParam("filtro") String filtro,
    					   @PathParam("texto") String texto) throws SQLException {
		emf = Persistence.createEntityManagerFactory("persistencia");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		
		Query query = null;
		switch (filtro) {
		case "nombrePelicula":
			query = manager.createQuery("FROM Pelicula WHERE nombre LIKE :nombre ");
			query.setParameter("nombre", "%" + texto + "%");
			break;
		case "actor":
			query = manager.createNativeQuery(""
					+ "SELECT peli.id_pelicula, peli.imagen FROM Pelicula as peli "
					+ "INNER JOIN Personaje as pe "
					+ "ON peli.id_pelicula = pe.id_pelicula "
					+ "WHERE pe.nombre LIKE :nombre GROUP BY peli.id_pelicula ");
			query.setParameter("nombre", "%" + texto + "%");
			break;
		case "director":
			query = manager.createNativeQuery(""
					+ "SELECT peli.id_pelicula, peli.imagen FROM Pelicula as peli "
					+ "INNER JOIN Director as di "
					+ "ON peli.id_director = di.id_director "
					+ "WHERE di.nombre LIKE :nombre GROUP BY peli.id_pelicula ");
			query.setParameter("nombre", "%" + texto + "%");
			break;
		case "genero":
			query = manager.createNativeQuery(""
					+ "SELECT peli.id_pelicula, peli.imagen FROM Pelicula as peli "
					+ "INNER JOIN Categoria as ca "
					+ "ON peli.id_categoria = ca.id_categoria "
					+ "WHERE ca.nombre LIKE :nombre GROUP BY peli.id_pelicula ");
			query.setParameter("nombre", "%" + texto + "%");
			break;
		case "bodega":
			query = manager.createNativeQuery(""
					+ "SELECT peli.id_pelicula, peli.imagen FROM Pelicula as peli "
					+ "INNER JOIN Bodega as bo "
					+ "ON peli.id_bodega = bo.id_bodega "
					+ "WHERE bo.nombre LIKE :nombre GROUP BY peli.id_pelicula ");
			query.setParameter("nombre", "%" + texto + "%");
			break;
		case "formato":
			query = manager.createNativeQuery(""
					+ "SELECT peli.id_pelicula, peli.imagen FROM Pelicula as peli "
					+ "INNER JOIN Formato as fo "
					+ "ON peli.id_formato = fo.id_formato "
					+ "WHERE fo.nombre LIKE :nombre GROUP BY peli.id_pelicula ");
			query.setParameter("nombre", "%" + texto + "%");
			break;
		case "estudio":
			query = manager.createNativeQuery(""
					+ "SELECT peli.id_pelicula, peli.imagen FROM Pelicula as peli "
					+ "INNER JOIN DistribuidorEstudio as de "
					+ "ON peli.id_distribuidorEstudio = de.id_distribuidorEstudio "
					+ "WHERE de.nombre LIKE :nombre GROUP BY peli.id_pelicula ");
			query.setParameter("nombre", "%" + texto + "%");
			
			break;
		}
		
		return query.getResultList();
	}

}
