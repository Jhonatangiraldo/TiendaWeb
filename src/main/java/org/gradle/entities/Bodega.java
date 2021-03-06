package org.gradle.entities;

import java.util.ArrayList;
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
@Table(name = "Bodega")
@XmlRootElement
public class Bodega {
	
	public Bodega() {
		/*
		 * Constructor empty
		 */
	}
	
	public Bodega(Long idbodega, String nombre) {
		this.id_bodega = idbodega;
		this.nombre = nombre;
	}
	
	public Bodega(Long idbodega) {
		this.id_bodega = idbodega;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bodega")
	private Long id_bodega;
	
	@OneToMany(mappedBy = "bodega", cascade = CascadeType.ALL)
	private List<Pelicula> peliculas = new ArrayList<>();
	
	@Column(name = "nombre")
	private String nombre;
	
	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement
	public Long getId_bodega() {
		return id_bodega;
	}

	public void setId_bodega(Long id_bodega) {
		this.id_bodega = id_bodega;
	}
	
	@XmlElement
	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void addPelicula(Pelicula pelicula){
		if (!peliculas.contains(pelicula)){
			pelicula.setBodega(this);
			peliculas.add(pelicula);
		}
	}
	
	public void deletePelicula(Pelicula pelicula){
		if (peliculas.contains(pelicula)){
			peliculas.remove(pelicula);
			pelicula.setBodega(null);
		}
	}

	@Override
	public String toString() {
		return "Bodega [id_bodega=" + id_bodega + ", peliculas=" + peliculas.size()
				+ "]";
	}
}
