package entities;

import static org.junit.Assert.*;

import org.gradle.entities.Bodega;
import org.gradle.entities.Pelicula;
import org.gradle.entities.Personaje;
import org.junit.Before;
import org.junit.Test;

public class TestBodega {
	
	Personaje personjePrueba;
	Pelicula pelicula;
	
	@Before
	public void preparar(){
		pelicula = new Pelicula();
		personjePrueba = new Personaje(1l, pelicula, "Personaje");
	}

	@Test
	public void test() {
		Personaje personaje = new Personaje(1L);
		personaje.setNombre("Personaje");
		personaje.setPelicula(pelicula);
		
		assertEquals(personjePrueba.getId_personaje(), personaje.getId_personaje());
		assertEquals(personjePrueba.getNombre(), personaje.getNombre());
		assertEquals(personjePrueba.toString(), personaje.toString());
		assertEquals(personjePrueba.getPelicula(), personaje.getPelicula());
	}

}
