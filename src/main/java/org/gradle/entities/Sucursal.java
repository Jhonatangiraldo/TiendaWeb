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
@Table(name = "Sucursal")
@XmlRootElement
public class Sucursal {
	
	public Sucursal() {
	}
	
	public Sucursal(Long id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_sucursal")
	private Long id_sucursal;
	
	@OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
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

	public Long getId_sucursal() {
		return id_sucursal;
	}

	public void setId_sucursal(Long id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	@Override
	public String toString() {
		return "Sucursal [id_sucursal=" + id_sucursal + " ]";
	}
}
