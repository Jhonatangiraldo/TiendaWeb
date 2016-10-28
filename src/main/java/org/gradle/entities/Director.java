package org.gradle.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@Entity
@Table(name = "Director")
public class Director {
	
	public Director() {
	}
	
	public Director(Long id_director) {
		this.id_director = id_director;
	}

	@Id
	@Column(name = "id_director")
	private Long id_director;
	
	@OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
	private List<Pelicula> peliculas;
	
	@Column(name = "nombre")
	private Long nombre;
	
	@XmlElement
	public Long getNombre() {
		return nombre;
	}

	public void setNombre(Long nombre) {
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
