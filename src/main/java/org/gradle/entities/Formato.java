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
@Table(name = "Formato")
@XmlRootElement
public class Formato {
	
	public Formato() {
		/*
		 * Hibernate
		 */
	}
		
	public Formato(Long id_formato, String nombre) {
		this.id_formato = id_formato;
		this.nombre = nombre;
	}

	public Formato(Long idformato) {
		this.id_formato = idformato;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_formato")
	private Long id_formato;
	
	@OneToMany(mappedBy = "formato", cascade = CascadeType.ALL)
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

	public Long getId_formato() {
		return id_formato;
	}

	public void setId_formato(Long id_formato) {
		this.id_formato = id_formato;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
	public void addPelicula(Pelicula pelicula){
		if (!peliculas.contains(pelicula)){
			pelicula.setFormato(this);
			peliculas.add(pelicula);
		}
	}
	
	public void deletePelicula(Pelicula pelicula){
		if (peliculas.contains(pelicula)){
			peliculas.remove(pelicula);
			pelicula.setFormato(null);
		}
	}

	@Override
	public String toString() {
		return "Formato [id_formato=" + id_formato + ", peliculas=" + peliculas.size()
				+ "]";
	}
	
	
}
