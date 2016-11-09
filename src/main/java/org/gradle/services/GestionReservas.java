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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gradle.Respuesta;
import org.gradle.entities.Pelicula;

@Path("/reservas")
public class GestionReservas {
	
	EntityManagerFactory emf;
	EntityManager manager;
	
	@POST
    @Path("/reservas")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pelicula> reservas() throws SQLException {
		emf = Persistence.createEntityManagerFactory("persistencia");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		
		Query query = manager.createNativeQuery(" SELECT pe.id_pelicula, pe.nombre FROM pelicula pe "
											  + " INNER JOIN reserva re ON pe.id_pelicula = re.id_pelicula ");
		return query.getResultList();
	}
	
	@POST
    @Path("/eliminarReservas")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta Eliminarreservas() throws SQLException {
		emf = Persistence.createEntityManagerFactory("persistencia");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		
		Query query = manager.createQuery("DELETE FROM reserva");
		query.executeUpdate();
		return new Respuesta();
	}
}
