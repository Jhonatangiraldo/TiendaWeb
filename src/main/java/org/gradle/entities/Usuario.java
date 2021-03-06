package org.gradle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Usuario")
@XmlRootElement
public class Usuario {
	
	public Usuario() {
	}
	
	public Usuario(String usuario, String contrasena) {
		this.usuario = usuario;
		this.contrasena = contrasena;	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Long id_usuario;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "contrasena")
	private String contrasena;

	@XmlElement
	public Long getId_Usuario() {
		return id_usuario;
	}

	public void setIdUsuario(Long id) {
		this.id_usuario = id;
	}

	@XmlElement
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@XmlElement
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	

}
