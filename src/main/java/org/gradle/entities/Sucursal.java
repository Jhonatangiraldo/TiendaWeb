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
@Table(name = "Sucursal")
public class Sucursal {
	
	public Sucursal() {
	}
	
	public Sucursal(Long id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	@Id
	@Column(name = "id_sucursal")
	private Long id_sucursal;
	
	@OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
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

	public Long getId_sucursal() {
		return id_sucursal;
	}

	public void setId_sucursal(Long id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public String toString() {
		return "Sucursal [id_sucursal=" + id_sucursal + ", peliculas="
				+ peliculas.size() + "]";
	}
}
