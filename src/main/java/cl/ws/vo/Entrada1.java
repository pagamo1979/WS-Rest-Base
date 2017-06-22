package cl.ws.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Entrada1 implements Serializable{

	
	String toMail;
	String toMails;
	String toSubject;
	String bodyMsg;
	String fromEmail;
	
	public String getToMail() {
		return toMail;
	}
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}
	public String getToMails() {
		return toMails;
	}
	public void setToMails(String toMails) {
		this.toMails = toMails;
	}
	public String getToSubject() {
		return toSubject;
	}
	public void setToSubject(String toSubject) {
		this.toSubject = toSubject;
	}
	public String getBodyMsg() {
		return bodyMsg;
	}
	public void setBodyMsg(String bodyMsg) {
		this.bodyMsg = bodyMsg;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

}
