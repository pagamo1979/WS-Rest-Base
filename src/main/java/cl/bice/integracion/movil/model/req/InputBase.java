package cl.bice.integracion.movil.model.req;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InputBase implements Serializable{

	private String dispositivo;
	private String token;
	private String rut;
	private String codServicio;
	
	public String getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rutCliente) {
		this.rut = rutCliente;
	}
	public String getCodServicio() {
		return codServicio;
	}
	public void setCodServicio(String codServicio) {
		this.codServicio = codServicio;
	} 
	
}
