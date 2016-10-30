package org.gradle.services;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.gradle.Respuesta;
import org.gradle.entities.Bodega;
import org.gradle.entities.Pelicula;
import org.gradle.entities.Usuario;


@Path("/security_service")
public class ServicioSeguridad {
	
	EntityManagerFactory emf;
	EntityManager manager;
	
	@POST
    @Path("/registro/{usuario}/{pass}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registro(@PathParam("usuario") String usuario,
    						  @PathParam("pass") String pass) throws SQLException {
		emf = Persistence.createEntityManagerFactory("persistencia");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		
		//validacion no hallan mismos usuarios
		Query query = manager.createQuery("FROM Usuario WHERE usuario =:usuario");
		query.setParameter("usuario", usuario);
		
		if (query.getResultList().size() > 0 ){
			return new Respuesta("fail");
		}else{
			Usuario usuarioEnty = new Usuario(usuario, pass);
			manager.persist(usuarioEnty);
			manager.getTransaction().commit();
			return new Respuesta();
		}
	}
	
	@POST
    @Path("/login/{usuario}/{pass}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta login(@PathParam("usuario") String usuario,
    					   @PathParam("pass") String pass) throws SQLException {
		emf = Persistence.createEntityManagerFactory("persistencia");
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		
		//validacion exista el usuario con su contraseña
		Query query = manager.createQuery("FROM Usuario WHERE usuario =:usuario and contrasena =:pass");
		query.setParameter("usuario", usuario);
		query.setParameter("pass", pass);
		
		if (query.getResultList().size() > 0 ){
			return new Respuesta();
		}else{
			return new Respuesta("fail");
		}
	}
	
}
