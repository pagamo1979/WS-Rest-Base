package cl.bice.integracion.movil.model.resp;



import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;



@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility =Visibility.NONE, setterVisibility = Visibility.NONE)
public class ValidaConDetResp {
	  /**
     * Estado de la peticion.
     */
    @JsonProperty("estado")
    private EstadoResp estado;
    
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
