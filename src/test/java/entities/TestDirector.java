package entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.gradle.entities.Director;
import org.gradle.entities.Pelicula;
import org.junit.Before;
import org.junit.Test;

public class TestDirector {

	Director directorPrueba;
	
	@Before
	public void preparar(){
		directorPrueba = new Director(1l, "Director 1");
		List<Pelicula> peliculas = new ArrayList<>();
		directorPrueba.setPeliculas(peliculas);
	}

	@Test
	public void test() {
		Director director = new Director();
		Pelicula pelicula = new Pelicula();
		List<Pelicula> peliculas = new ArrayList<>();
		director.setPeliculas(peliculas);
		director.addPelicula(pelicula);
		director.deletePelicula(pelicula);
		director.setId_director(1L);
		director.setNombre("Director 1");
		
		assertEquals(directorPrueba.getId_director(), director.getId_director());
		assertEquals(directorPrueba.getNombre(), director.getNombre());
		assertEquals(directorPrueba.toString(), director.toString());
		assertEquals(0, director.getPeliculas().size());
	}

}
