package org.gradle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Respuesta {

	public Respuesta() {
		this.respuesta = "Ok";
	}
	
	public Respuesta(String respuesta){
		this.respuesta = respuesta;
	}
	
	@XmlElement
	private String respuesta;

	@XmlElement
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	
}
