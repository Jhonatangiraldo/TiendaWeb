package org.gradle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@Entity
@Table(name = "Usuario")
@XmlRootElement
public class Usuario {
	
	public Usuario() {
	}
	
	public Usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	@Id
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
