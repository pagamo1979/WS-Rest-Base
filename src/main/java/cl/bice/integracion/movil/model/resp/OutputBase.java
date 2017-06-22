package cl.bice.integracion.movil.model.resp;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "respuesta")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class OutputBase {
	
	EstadoResp repuesta;

	public EstadoResp getRepuesta() {
		return repuesta;
	}

	public void setRepuesta(EstadoResp repuesta) {
		this.repuesta = repuesta;
	}

	
}