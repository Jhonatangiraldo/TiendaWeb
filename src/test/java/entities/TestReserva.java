package entities;

import static org.junit.Assert.assertEquals;

import org.gradle.entities.Bodega;
import org.gradle.entities.Pelicula;
import org.gradle.entities.Reserva;
import org.junit.Before;
import org.junit.Test;

public class TestReserva {

	Reserva reservaPrueba;
	
	@Before
	public void preparar(){
		reservaPrueba = new Reserva("Final", "Inicio", 1L, 1L, 100L);
		reservaPrueba.setId_reserva(1L);
	}

	@Test
	public void test() {
		Reserva reserva = new Reserva();
		reserva.setFechaInicio("Inicio");
		reserva.setFechaFinal("Final");
		reserva.setId_pelicula(1L);
		reserva.setId_reserva(1L);
		reserva.setId_usuario(1L);
		reserva.setPrecioTotal(100L);
		reserva.setId_reserva(1L);
		
		assertEquals(reservaPrueba.getFechaFinal(), reserva.getFechaFinal());
		assertEquals(reservaPrueba.getFechaInicio(), reserva.getFechaInicio());
		assertEquals(reservaPrueba.getId_pelicula(), reserva.getId_pelicula());
		assertEquals(reservaPrueba.getId_reserva(), reserva.getId_reserva());
		assertEquals(reservaPrueba.getId_usuario(), reserva.getId_usuario());
		assertEquals(reservaPrueba.getPrecioTotal(), reserva.getPrecioTotal());
	}
}
