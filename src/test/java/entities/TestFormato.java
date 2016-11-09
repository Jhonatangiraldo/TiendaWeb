package entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.gradle.entities.Formato;
import org.gradle.entities.Pelicula;
import org.junit.Before;
import org.junit.Test;

public class TestFormato {

	Formato formato;
	
	@Before
	public void preparar(){
		formato = new Formato(1l, "Formato 1");
		List<Pelicula> peliculas = new ArrayList<>();
		formato.setPeliculas(peliculas);
	}

	@Test
	public void test() {
		Formato distribuidorEstudio = new Formato();
		Pelicula pelicula = new Pelicula();
		List<Pelicula> peliculas = new ArrayList<>();
		distribuidorEstudio.setPeliculas(peliculas);
		distribuidorEstudio.addPelicula(pelicula);
		distribuidorEstudio.deletePelicula(pelicula);
		distribuidorEstudio.setId_formato(1L);
		distribuidorEstudio.setNombre("Formato 1");
		
		assertEquals(formato.getId_formato(), distribuidorEstudio.getId_formato());
		assertEquals(formato.getNombre(), distribuidorEstudio.getNombre());
		assertEquals(formato.toString(), distribuidorEstudio.toString());
		assertEquals(0, distribuidorEstudio.getPeliculas().size());
	}

}
