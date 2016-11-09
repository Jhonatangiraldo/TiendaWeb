package entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.gradle.entities.*;
import org.junit.Before;
import org.junit.Test;

public class TestPelicula {
	
	Pelicula peliculaPrueba;
	
	@Before
	public void preparar(){
		peliculaPrueba = new Pelicula(1L, new Bodega(1L), new Sucursal(1L), new Director(1L), new Categoria(1L), 
									new Formato(1L), new DistribuidorEstudio(1L), "Terminator", 100L, "Imagen1");
	}

	@Test
	public void test() {
		Pelicula pelicula = new Pelicula();
		pelicula.setId_pelicula(1L);
		pelicula.setBodega(new Bodega(1L));
		pelicula.setSucursal(new Sucursal(1L));
		pelicula.setDirector(new Director(1L));
		pelicula.setCategoria(new Categoria(1L));
		pelicula.setFormato(new Formato(1L));
		pelicula.setDistribuidorEstudio(new DistribuidorEstudio(1L));
		pelicula.setNombre("Terminator");
		pelicula.setCostoHora(100L);
		pelicula.setImagen("Imagen1");
		
		List<Personaje> personajes = new ArrayList<>();
		pelicula.setPersonajes(personajes);
		
		Personaje personaje = new Personaje(1L);
		pelicula.addPersonaje(personaje);
		pelicula.deletePersonaje(personaje);
		
		assertEquals(0, pelicula.getPersonajes().size());
		assertEquals(peliculaPrueba.getId_pelicula(), pelicula.getId_pelicula());
		assertEquals(peliculaPrueba.getBodega().getId_bodega(), pelicula.getBodega().getId_bodega());
		assertEquals(peliculaPrueba.getSucursal().getId_sucursal(), pelicula.getSucursal().getId_sucursal());
		assertEquals(peliculaPrueba.getDirector().getId_director() , pelicula.getDirector().getId_director() );
		assertEquals(peliculaPrueba.getCategoria().getId_categoria() , pelicula.getCategoria().getId_categoria() );
		assertEquals(peliculaPrueba.getFormato().getId_formato() , pelicula.getFormato().getId_formato() );
		assertEquals(peliculaPrueba.getDistribuidorEstudio().getId_distribuidorEstudio(), 
					 pelicula.getDistribuidorEstudio().getId_distribuidorEstudio() );
		assertEquals(peliculaPrueba.toString(), pelicula.toString());
		assertEquals(peliculaPrueba.getNombre(), pelicula.getNombre());
		assertEquals(peliculaPrueba.getCostoHora(), pelicula.getCostoHora());
		assertEquals(peliculaPrueba.getImagen(), pelicula.getImagen());
	}

}
