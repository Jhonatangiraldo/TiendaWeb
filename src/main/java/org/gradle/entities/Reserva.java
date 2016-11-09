package org.gradle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Reserva")
@XmlRootElement
public class Reserva {
	
	public Reserva() {
		/*
		 * Para hibernate
		 */
	}
	
	public Reserva(String fechaFinal, String fechaInicio, Long id_pelicula, Long id_usuario, Long precioTotal) {
		this.fechaFinal = fechaFinal;
		this.fechaInicio = fechaInicio;
		this.id_pelicula = id_pelicula;
		this.id_usuario = id_usuario;
		this.precioTotal = precioTotal;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_reserva")
	private Long id_reserva;
	
	@Column(name = "id_usuario")
	private Long id_usuario;
	
	@Column(name = "id_pelicula")
	private Long id_pelicula;
	
	@Column(name = "fechaInicio")
	private String fechaInicio;
	
	@Column(name = "fechaFinal")
	private String fechaFinal;
	
	@Column(name = "precioTotal")
	private Long precioTotal;

	@XmlElement
	public Long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Long id_reserva) {
		this.id_reserva = id_reserva;
	}

	@XmlElement
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	@XmlElement
	public Long getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(Long id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	@XmlElement
	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@XmlElement
	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@XmlElement
	public Long getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Long precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	

}
