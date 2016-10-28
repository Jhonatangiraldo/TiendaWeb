package org.gradle.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@Entity
@Table(name = "Bodega")
@XmlRootElement
public class Bodega {
	
	public Bodega() {
		// TODO Auto-generated constructor stub
	}
	
	public Bodega(Long id_bodega) {
		this.id_bodega = id_bodega;
	}

	@Id
	@Column(name = "id_bodega")
	private Long id_bodega;
	
	@OneToMany(mappedBy = "bodega", cascade = CascadeType.ALL)
	private List<Pelicula> peliculas = new ArrayList<>();
	
	@Column(name = "nombre")
	private Long nombre;
	
	@XmlElement
	public Long getNombre() {
		return nombre;
	}

	public void setNombre(Long nombre) {
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

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
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
