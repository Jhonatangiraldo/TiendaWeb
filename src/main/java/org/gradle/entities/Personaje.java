package org.gradle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@Entity
@Table(name = "Personaje")
public class Personaje {
	
	public Personaje() {
	}
	
	public Personaje(Long id_personaje) {
		this.id_personaje = id_personaje;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_personaje")
	private Long id_personaje;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pelicula")
	@JsonBackReference
	private Pelicula pelicula;
	
	@Column(name = "nombre")
	private String nombre;
	
	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId_personaje() {
		return id_personaje;
	}

	public void setId_personaje(Long id_personaje) {
		this.id_personaje = id_personaje;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula peliculas) {
		this.pelicula = peliculas;
	}
	
	@Override
	public String toString() {
		return "Personaje [id_director=" + id_personaje + ", peliculas="
				+ pelicula.getId_pelicula() + "]";
	}
	
	

}
