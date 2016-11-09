package entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.gradle.entities.Categoria;
import org.gradle.entities.Pelicula;
import org.junit.Before;
import org.junit.Test;

public class TestCategoria {
	
	Categoria categoriaPrueba;
	
	@Before
	public void preparar(){
		categoriaPrueba = new Categoria(1l, "Categoria 1");
		List<Pelicula> peliculas = new ArrayList<>();
		categoriaPrueba.setPeliculas(peliculas);
	}

	@Test
	public void test() {
		Categoria categoria = new Categoria();
		categoria.setId_categoria(1L);
		categoria.setNombre("Categoria 1");
		List<Pelicula> peliculas = new ArrayList<>();
		categoria.setPeliculas(peliculas);
		Pelicula pelicula = new Pelicula(); 
		categoria.addPelicula(pelicula);
		categoria.deletePelicula(pelicula);
		
		assertEquals(categoriaPrueba.getId_categoria(), categoria.getId_categoria());
		assertEquals(categoriaPrueba.getNombre(), categoria.getNombre());
		assertEquals(categoriaPrueba.toString(), categoria.toString());
		assertEquals(0, categoria.getPeliculas().size());
	}
}
