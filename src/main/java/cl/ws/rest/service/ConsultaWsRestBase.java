package cl.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.bice.integracion.movil.model.req.InputBase;
import cl.bice.integracion.movil.model.resp.EstadoResp;
import cl.bice.integracion.movil.model.resp.OutputBase;



/** 
 * Metodo del servicio REST que realiza la consulta de periodos para tarjetas. 
 * @param Datos del request.
 * @return Respuesta del servicio.
 */
@Path("/base")
public class ConsultaWsRestBase {
	
	public final int HTTP_STATUS_OK=200;
	public static final String STR_CONTENT_TYPE	= "application/json; charset=ISO-8859-1";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultaWsRestBase.class);
		
	@POST
	@Path("/metodoRest1") 
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	public Response metodoConsulta1 (InputBase req) throws Exception {	
		//Aqui se deberia llamar delegate para hacer algo y el resultado asignarlo a la clase de salida

		LOGGER.info("INIT metodoConsulta1");
		System.out.println("metodoRest1");
		LOGGER.info(req.getCodServicio());
		LOGGER.info(req.getDispositivo());
		LOGGER.info(req.getRut());
		LOGGER.info(req.getToken());
		
		OutputBase resp = new OutputBase ();	
		EstadoResp estado = new EstadoResp();
		estado.setCodigoEstado("1");
		estado.setGlosaEstado("OK");
		resp.setRepuesta(estado);
	
	return Response.status(HTTP_STATUS_OK).type(STR_CONTENT_TYPE).entity(resp).build();
	}
	
	@GET
	@Path("/index") 
	public Response metodoIndex (String msg) {	
		//Aqui se deberia llamar delegate para hacer algo y el resultado asignarlo a la clase de salida
		//OutputBase resp = new OutputBase ();	
		//resp.setRepuesta(new RespuestaOut());
		String output = null;
		int status=0;    
		
		try{
			output = "Jersey saluda servicio GET rest : " + msg;
			LOGGER.debug(output);
			status=HTTP_STATUS_OK;
		}catch(Exception e){
			status=500;
		}finally{
		}
	
		return Response.status(status).
      		type(STR_CONTENT_TYPE).entity(output).build();
	}
}

