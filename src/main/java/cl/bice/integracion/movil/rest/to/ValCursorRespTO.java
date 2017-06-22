package cl.bice.integracion.movil.rest.to;


public class ValCursorRespTO {

	private String cod_id_control_trx;
	private String cod_campo;
	private String val_campo;
	

	public String getCod_id_control_trx() {
		return cod_id_control_trx;
	}
	public void setCod_id_control_trx(String cod_id_control_trx) {
		this.cod_id_control_trx = cod_id_control_trx;
	}
	
	public String getCod_campo() {
		return cod_campo;
	}
	public void setCod_campo(String cod_campo) {
		this.cod_campo = cod_campo;
	}
	public String getVal_campo() {
		return val_campo;
	}
	public void setVal_campo(String val_campo) {
		this.val_campo = val_campo;
	}
	
}
