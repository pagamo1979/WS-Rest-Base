package cl.bice.integracion.movil.model.dao.sp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.bice.integracion.movil.rest.to.ValCursorRespTO;



public class ValRowMapper implements RowMapper<ValCursorRespTO> {

    /** {@inheritDoc} */
    
	public ValCursorRespTO mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		ValCursorRespTO valResp = new ValCursorRespTO();
		
		valResp.setCod_id_control_trx(rs.getString("cod_id_control_trx"));
		valResp.setCod_campo(rs.getString("cod_campo"));
		valResp.setVal_campo(rs.getString("val_campo"));
	    return valResp;
	}
    
    
}

