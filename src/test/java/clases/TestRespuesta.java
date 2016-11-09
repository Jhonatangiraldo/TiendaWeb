package clases;

import static org.junit.Assert.assertEquals;

import org.gradle.Respuesta;
import org.junit.Before;
import org.junit.Test;

public class TestRespuesta {

	Respuesta respuestaPrueba;
	
	@Before
	public void preparar(){
		respuestaPrueba = new Respuesta("Respuesta 1");
	}

	@Test
	public void test() {
		Respuesta respuesta = new Respuesta();
		respuesta.setRespuesta("Respuesta 1");
		
		assertEquals(respuestaPrueba.getRespuesta(), respuesta.getRespuesta());
	}


}
