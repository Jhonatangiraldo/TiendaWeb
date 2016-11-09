package entities;

import static org.junit.Assert.assertEquals;

import org.gradle.entities.Bodega;
import org.gradle.entities.Pelicula;
import org.junit.Before;
import org.junit.Test;

public class TestPersonaje {

	Bodega bodegaPrueba;
	
	@Before
	public void preparar(){
		bodegaPrueba = new Bodega(1l, "Bodega 1");
	}

	@Test
	public void test() {
		Bodega bodega = new Bodega();
		Pelicula pelicula = new Pelicula();
		bodega.addPelicula(pelicula);
		bodega.deletePelicula(pelicula);
		bodega.setId_bodega(1L);
		bodega.setNombre("Bodega 1");
		
		assertEquals(bodegaPrueba.getId_bodega(), bodega.getId_bodega());
		assertEquals(bodegaPrueba.getNombre(), bodega.getNombre());
		assertEquals(bodegaPrueba.toString(), bodega.toString());
		assertEquals(0, bodega.getPeliculas().size());
	}
}
