package entities;

import static org.junit.Assert.assertEquals;

import org.gradle.entities.Pelicula;
import org.gradle.entities.Personaje;
import org.gradle.entities.Sucursal;
import org.junit.Before;
import org.junit.Test;

public class TestSucursal {
	
	Sucursal sucursalPrueba;
	
	@Before
	public void preparar(){
		sucursalPrueba = new Sucursal(1l);
		sucursalPrueba.setNombre("Sucursal");
	}

	@Test
	public void test() {
		Sucursal sucursal = new Sucursal();
		sucursal.setNombre("Sucursal");
		sucursal.setId_sucursal(1L);
		
		assertEquals(sucursalPrueba.getId_sucursal(), sucursal.getId_sucursal());
		assertEquals(sucursalPrueba.getNombre(), sucursal.getNombre());
		assertEquals(sucursalPrueba.toString(), sucursal.toString());
	}

}
