package cl.bice.integracion.movil.model.req;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonProperty;

import cl.bice.integracion.movil.model.resp.EstadoResp;
import cl.bice.integracion.movil.rest.to.ValCursorRespTO;



@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility =Visibility.NONE, setterVisibility = Visibility.NONE)
public class GetDetalleResp {

    /**
     * Estado de la peticion.
     */
    @JsonProperty("estado")
    private EstadoResp estado;
    
    
    private List<ValCursorRespTO> detalle = new ArrayList<ValCursorRespTO>();

   	public List<ValCursorRespTO> getDetalle() {
   		return detalle;
   	}

   	public void setParametros(List<ValCursorRespTO> detalle) {
   		this.detalle = detalle;
   	}
    
   

    /**
     * Permite obtener el valor del atributo estado.
     *
     * @return retorna el valor del atributo estado.
     */
    public EstadoResp getEstado() {
        return estado;
    }

    /**
     * Permite setear el valor del atributo estado.
     *
     * @param estado nuevo valor para el atributo estado.
     */
    public void setEstado(EstadoResp estado) {
        this.estado = estado;
    }

	

   
    
    
}
