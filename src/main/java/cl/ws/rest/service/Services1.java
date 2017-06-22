package cl.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cl.ws.delegate.Correo;
import cl.ws.vo.Entrada1;
import cl.ws.vo.OutputBase;
import cl.ws.vo.Respuesta;


/** 
 * Metodo del servicio REST que realiza la consulta de periodos para tarjetas. 
 * @param Datos del request.
 * @return Respuesta del servicio.
 */
@Path("/ser1")
public class Services1 {
	
	public final int HTTP_STATUS_OK=200;
	public static final String STR_CONTENT_TYPE	= "application/json; charset=UTF-8";
		
	@POST
	@Path("/sendMsg") 
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	public Response metodoMsg1 (Entrada1 req) {	
	System.out.println("/metodoMsg1");
    //Aqui se deberia llamar delegate para hacer algo y el resultado asignarlo a la clase de salida		
    OutputBase resp = new OutputBase ();	
    System.out.println("paso1");
    
    Correo mailDel = new Correo();
    mailDel.callMsg(req);
    System.out.println("paso2");
    Respuesta ro = new Respuesta();
    ro.setCodSalida("1");
    ro.setMsgSalida("OK");
	resp.setResp(ro);
	
	return Response.status(HTTP_STATUS_OK).
      		type(STR_CONTENT_TYPE).entity(resp).build();
	}

	
	/*
      @GET
	@Path("/index") 
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	public Response metodoIndex (String imp) {	
		//Aqui se deberia llamar delegate para hacer algo y el resultado asignarlo a la clase de salida
		OutputBase resp = new OutputBase ();	
		resp.setRepuesta(new RespuestaOut());
	
	return Response.status(HTTP_STATUS_OK).
      		type(STR_CONTENT_TYPE).entity(resp).build();
	}
	*/
}

