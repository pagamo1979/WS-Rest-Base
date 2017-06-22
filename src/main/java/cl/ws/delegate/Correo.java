package cl.ws.delegate;

import org.apache.log4j.Logger;

import cl.ws.util.EmailUtil;
import cl.ws.vo.Entrada1;

public class Correo {
	private Logger LOGGER = Logger.getLogger(Correo.class);
	
	public void callMsg(Entrada1 inp) {
		
		//LOGGER.debug("Mensaje "+inp.getToMail() + inp.getToMails() + inp.getToSubject());
		System.out.println("Mensaje "+inp.getToMail() + ", "+inp.getToMails() + ", "+ inp.getToSubject() + ", "+ inp.getBodyMsg());
		EmailUtil.enviarEmail(inp);
	
	}

}
