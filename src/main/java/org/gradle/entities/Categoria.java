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
@Table(name = "Categoria")
public class Categoria {
	
	public Categoria() {
	}
	
	public Categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	@Id
	@Column(name = "id_categoria")
	private Long id_categoria;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
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

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
	public void addPelicula(Pelicula pelicula){
		if (!peliculas.contains(pelicula)){
			pelicula.setCategoria(this);
			peliculas.add(pelicula);
		}
	}
	
	public void deletePelicula(Pelicula pelicula){
		if (peliculas.contains(pelicula)){
			peliculas.remove(pelicula);
			pelicula.setCategoria(null);
		}
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", peliculas="
				+ peliculas.size() + "]";
	}
}
