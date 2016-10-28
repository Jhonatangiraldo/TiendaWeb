package org.gradle.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Reserva")
@XmlRootElement
public class Reserva {
	
	public Reserva() {
	}
	
	@Id
	@Column(name = "id_reserva")
	private Long id_sereserva;
	
	@Column(name = "id_usuario")
	private Long id_usuario;
	
	@Column(name = "id_pelicula")
	private Long id_pelicula;
	
	@Column(name = "fechaInicio")
	private Calendar fechaInicio;
	
	@Column(name = "fechaFinal")
	private Calendar fechaFinal;
	
	@Column(name = "precioTotal")
	private Calendar precioTotal;

}
