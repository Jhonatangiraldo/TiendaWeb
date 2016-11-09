package org.gradle.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Director")
@XmlRootElement
public class Director {
	
	public Director() {
		/*
		 * Para hibernate
		 */
	}
	
	public Director(Long id_director, String nombre) {
		this.id_director = id_director;
		this.nombre = nombre;
	}

	public Director(Long iddirector) {
		this.id_director = iddirector;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_director")
	private Long id_director;
	
	@OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
	private List<Pelicula> peliculas;
	
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

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
	public void addPelicula(Pelicula pelicula){
		if (!peliculas.contains(pelicula)){
			pelicula.setDirector(this);
			peliculas.add(pelicula);
		}
	}
	
	public void deletePelicula(Pelicula pelicula){
		if (peliculas.contains(pelicula)){
			peliculas.remove(pelicula);
			pelicula.setDirector(null);
		}
	}

	@Override
	public String toString() {
		return "Director [id_director=" + id_director + ", peliculas="
				+ peliculas.size() + "]";
	}
}
