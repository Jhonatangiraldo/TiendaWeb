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
	

	@GET
	@Path("/")
	public String inicio(){
		return  "Hola Mundo";
	}
	
	@GET
    @Path("/hello1")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayhello2() {
		emf = Persistence.createEntityManagerFactory("persistencia");
		manager = emf.createEntityManager();
		
		Bodega bodega = new Bodega();
		bodega.setNombre("Nombre");
		bodega.addPelicula(new Pelicula("Pelicula 1"));
		
		manager.getTransaction().begin();
		manager.persist(bodega);
		manager.getTransaction().commit();
		return "YES";
	}
	
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
	
}
