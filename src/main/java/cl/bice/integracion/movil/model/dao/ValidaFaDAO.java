package cl.bice.integracion.movil.model.dao;


import cl.bice.integracion.movil.model.req.InputFA;
import cl.bice.integracion.movil.model.resp.EstadoResp;
import cl.bice.integracion.movil.model.resp.ValidaConDetResp;
import cl.bice.integracion.movil.model.resp.ValidaSfaResp;

public interface ValidaFaDAO {
	
	ValidaSfaResp validaSfaControl(InputFA req);
	
	ValidaConDetResp validaConDetalle(InputFA req);
	
	

}
