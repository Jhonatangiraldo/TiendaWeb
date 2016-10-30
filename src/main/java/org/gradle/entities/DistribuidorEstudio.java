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

import com.sun.xml.internal.txw2.annotation.XmlElement;

@Entity
@Table(name = "DistribuidorEstudio")
public class DistribuidorEstudio {
	
	public DistribuidorEstudio() {
	}
	
	public DistribuidorEstudio(Long id_distribuidorEstudio) {
		this.id_distribuidorEstudio = id_distribuidorEstudio;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_distribuidorEstudio")
	private Long id_distribuidorEstudio;
	
	@OneToMany(mappedBy = "distribuidorEstudio", cascade = CascadeType.ALL)
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

	public Long getId_distribuidorEstudio() {
		return id_distribuidorEstudio;
	}

	public void setId_distribuidorEstudio(Long id_distribuidorEstudio) {
		this.id_distribuidorEstudio = id_distribuidorEstudio;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
	public void addPelicula(Pelicula pelicula){
		if (!peliculas.contains(pelicula)){
			pelicula.setDistribuidorEstudio(this);
			peliculas.add(pelicula);
		}
	}
	
	public void deletePelicula(Pelicula pelicula){
		if (peliculas.contains(pelicula)){
			peliculas.remove(pelicula);
			pelicula.setDistribuidorEstudio(null);
		}
	}

	@Override
	public String toString() {
		return "DistribuidorEstudio [id_distribuidorEstudio="
				+ id_distribuidorEstudio + ", peliculas=" + peliculas.size() + "]";
	}
	
	
	
	

}
