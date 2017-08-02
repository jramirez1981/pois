package ar.com.curso.poi.controladores;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import ar.com.curso.poi.model.Pois;

@XmlRootElement
public class RespuestaServicio {
	private List<Pois> resultado;
	private String status;
	public List<Pois> getResultado() {
		return resultado;
	}
	public void setResultado(List<Pois> resultado) {
		this.resultado = resultado;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
