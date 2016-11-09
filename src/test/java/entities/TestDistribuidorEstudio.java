package entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.gradle.entities.DistribuidorEstudio;
import org.gradle.entities.Pelicula;
import org.junit.Before;
import org.junit.Test;

public class TestDistribuidorEstudio {

	DistribuidorEstudio distribuidorEstudioPrueba;
	
	@Before
	public void preparar(){
		distribuidorEstudioPrueba = new DistribuidorEstudio(1l, "DistribuidorEstudio 1");
		List<Pelicula> peliculas = new ArrayList<>();
		distribuidorEstudioPrueba.setPeliculas(peliculas);
	}

	@Test
	public void test() {
		DistribuidorEstudio distribuidorEstudio = new DistribuidorEstudio();
		Pelicula pelicula = new Pelicula();
		List<Pelicula> peliculas = new ArrayList<>();
		distribuidorEstudio.setPeliculas(peliculas);
		distribuidorEstudio.addPelicula(pelicula);
		distribuidorEstudio.deletePelicula(pelicula);
		distribuidorEstudio.setId_distribuidorEstudio(1L);
		distribuidorEstudio.setNombre("DistribuidorEstudio 1");
		
		assertEquals(distribuidorEstudioPrueba.getId_distribuidorEstudio(), distribuidorEstudio.getId_distribuidorEstudio());
		assertEquals(distribuidorEstudioPrueba.getNombre(), distribuidorEstudio.getNombre());
		assertEquals(distribuidorEstudioPrueba.toString(), distribuidorEstudio.toString());
		assertEquals(0, distribuidorEstudio.getPeliculas().size());
	}

}
