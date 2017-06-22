package cl.correo;

import cl.ws.delegate.Correo;
import cl.ws.vo.Entrada1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Correo co= new Correo();
		Entrada1 en = new Entrada1();
		en.setToMail("pagamo@gmail.com");
		en.setToSubject("test1");
		en.setBodyMsg("prueba email Main");
		co.callMsg(en);
	}

}
