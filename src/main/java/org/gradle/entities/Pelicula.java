package org.gradle.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@Entity
@Table(name = "Pelicula")
@XmlRootElement
public class Pelicula {
	
	public Pelicula() {
		// TODO Auto-generated constructor stub
	}
	
	public Pelicula(Long id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public Pelicula(Long id_pelicula, Bodega bodega, Sucursal sucursal, Director director, 
			Categoria categoria, Formato formato, DistribuidorEstudio distribuidorEstudio) {
		this.id_pelicula = id_pelicula;
		this.setBodega(bodega);
		this.sucursal = sucursal;
		this.director = director;
		this.categoria = categoria;
		this.formato = formato;
		this.distribuidorEstudio = distribuidorEstudio;
	}


	@Id
	@Column(name = "id_pelicula")
	private Long id_pelicula;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bodega")
	@JsonBackReference
	private Bodega bodega;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sucursal")
	@JsonBackReference
	private Sucursal sucursal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_director")
	@JsonBackReference
	private Director director;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL)
	private List<Personaje> personajes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	@JsonBackReference
	private Categoria categoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_formato")
	@JsonBackReference
	private Formato formato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_distribuidorEstudio")
	@JsonBackReference
	private DistribuidorEstudio distribuidorEstudio;
	
	@Column(name = "nombre")
	private Long nombre;
	
	@Column(name = "costoHora")
	private Long costoHora;
	
	@Column(name = "imagen")
	private String imagen; 
	
	@XmlElement
	public Long getNombre() {
		return nombre;
	}

	public void setNombre(Long nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement
	public Long getCostoHora() {
		return costoHora;
	}

	public void setCostoHora(Long costoHora) {
		this.costoHora = costoHora;
	}
	
	@XmlElement
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void addPersonaje(Personaje personaje){
		if (!personajes.contains(personaje)){
			personaje.setPelicula(this);
			personajes.add(personaje);
		}
	}
	
	public void deletePelicula(Personaje personaje){
		if (personajes.contains(personaje)){
			personajes.remove(personaje);
			personaje.setPelicula(null);
		}
	}

	@XmlElement
	public Long getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(Long id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	@XmlElement
	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}
	
	@XmlElement
	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@XmlElement
	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	@XmlElement
	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	@XmlElement
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@XmlElement
	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	@XmlElement
	public DistribuidorEstudio getDistribuidorEstudio() {
		return distribuidorEstudio;
	}

	public void setDistribuidorEstudio(DistribuidorEstudio distribuidorEstudio) {
		this.distribuidorEstudio = distribuidorEstudio;
	}

	@Override
	public String toString() {
		return "Pelicula [id_pelicula=" + id_pelicula + ", bodega=" + bodega.getId_bodega() +", sucursal=" + sucursal.getId_sucursal() + ", director="
				+ director.getId_director() + ", categoria=" + categoria.getId_categoria() + ", formato=" + formato.getId_formato()
				+ ", distribuidorEstudio=" + distribuidorEstudio.getId_distribuidorEstudio() + "]";
	}

	

	
	
	
	
}
