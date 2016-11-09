package org.gradle.services;

import java.sql.SQLException;
import java.util.ArrayList;
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
import org.gradle.entities.Reserva;

@Path("/gestion")
public class GestionPelicula {
	
	EntityManagerFactory emf;
	EntityManager manager;
	
	@POST
    @Path("/consultaDetalle/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pelicula> peliculas(@PathParam("id") Integer id) throws SQLException {
		emf = Persistence.createEntityManagerFactory("persistencia");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createNativeQuery(""
				+ "SELECT pel.id_pelicula, pel.costoHora, pel.nombre, "
				+ "bo.nombre bodega, ca.nombre categoria, di.nombre director, distr.nombre distribuidorEstudio, "
				+ "fo.nombre formato "
				+ "FROM pelicula pel "
				+ "INNER JOIN bodega bo ON pel.id_bodega = bo.id_bodega "
				+ "INNER JOIN categoria ca ON pel.id_categoria = ca.id_categoria "
				+ "INNER JOIN director di ON pel.id_director = di.id_director "
				+ "INNER JOIN distribuidorestudio distr ON pel.id_distribuidorEstudio = distr.id_distribuidorEstudio "
				+ "INNER JOIN formato fo ON pel.id_formato = fo.id_formato "
				+ "WHERE pel.id_pelicula = :id ");
				query.setParameter("id", id);
				return query.getResultList();
	}
	
	@POST
    @Path("/reservar/{fechaFinal}/{fechaInicio}/{id_pelicula}/{id_usuario}/{precioTotal}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta reservar(@PathParam("fechaFinal") String fechaFinal,
    							   @PathParam("fechaInicio") String fechaInicio,
    							   @PathParam("id_pelicula") Long idpelicula,
    							   @PathParam("id_usuario") Long idusuario,
    							   @PathParam("precioTotal") Long precioTotal)throws SQLException {
		emf = Persistence.createEntityManagerFactory("persistencia");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		
		Reserva reserva = new Reserva(fechaFinal, fechaInicio, idpelicula, idusuario, precioTotal);
		manager.persist(reserva);
		manager.getTransaction().commit();
		
		return new Respuesta();
	}
}
