package cl.bice.integracion.movil.model.req;

public class InputFA extends InputBase{

	
	private String tipoCliente;
	private String IPCliente;
	private String tipoFA;
	private String idDispositivo;
	private String valorFA;
	private String idControlTrx;
	
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public String getIPCliente() {
		return IPCliente;
	}
	public void setIPCliente(String iPCliente) {
		IPCliente = iPCliente;
	}
	public String getTipoFA() {
		return tipoFA;
	}
	public void setTipoFA(String tipoFA) {
		this.tipoFA = tipoFA;
	}
	public String getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	public String getValorFA() {
		return valorFA;
	}
	public void setValorFA(String valorFA) {
		this.valorFA = valorFA;
	}
	public String getIdControlTrx() {
		return idControlTrx;
	}
	public void setIdControlTrx(String idControl) {
		this.idControlTrx = idControl;
	}
	
}
