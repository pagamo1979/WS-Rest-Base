package cl.ws.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "respuesta")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class OutputBase {
	
	Respuesta resp;

	public Respuesta getResp() {
		return resp;
	}

	public void setResp(Respuesta resp) {
		this.resp = resp;
	}
	

}
