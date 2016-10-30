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
	
	public Personaje(Long id_director) {
		this.id_director = id_director;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_director")
	private Long id_director;
	
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

	public Long getId_director() {
		return id_director;
	}

	public void setId_director(Long id_director) {
		this.id_director = id_director;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula peliculas) {
		this.pelicula = peliculas;
	}
	
	@Override
	public String toString() {
		return "Personaje [id_director=" + id_director + ", peliculas="
				+ pelicula.getId_pelicula() + "]";
	}
	
	

}
