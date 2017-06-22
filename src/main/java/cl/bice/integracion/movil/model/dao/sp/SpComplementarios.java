package cl.bice.integracion.movil.model.dao.sp;

import java.util.HashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

@Component
public abstract class SpComplementarios<E> extends StoredProcedure{

    /**
     * Bandera que indica si ocurrio algun error en la ejecucion del SP
     */
    private boolean error   = false;
    
    /**
     * slf4j
     */    
	private final Logger LOGGER = LoggerFactory
			.getLogger(SpComplementarios.class);
    
    /**
     * Constante que representa el campo proveniente del SP con el 
     * codigo del estado de la consulta. 
     */
    protected static final String COD_ESTADO    = "COD_ESTADO";
    
    /**
     * Constante que representa el campo proveniente del SP con la 
     * descripcion del estado de la consulta. 
     */
    protected static final String GLS_ESTADO    = "GLS_ESTADO";
    
    /**
     * Constructor de la clase
     * @param ds Datasource
     * @param nombreSP nombrel del SP a ejecutar
     */
    public SpComplementarios(DataSource ds, String nombreSP){
        super();
        try {
            LOGGER.debug("Compilando SP " + nombreSP);
            setDataSource(ds);
            setFunction(false);
            setSql(nombreSP);

            // Parametros tipo IN
            LOGGER.debug("Se ingresan parametros tipo IN");
            setInParameters();
            
            // Parametros tipo OUT
            LOGGER.debug("Se ingresan parametros tipo OUT");
            setOutParameters();

            compile();
            LOGGER.debug("Fin Compilacion SP " + nombreSP);
        } catch (InvalidDataAccessApiUsageException e) {
            LOGGER.debug("Error al compilar el SP "
                + nombreSP);
        }
    }

    /**
     * Permite obtener el valor del atributo error.
     *
     * @return retorna el valor del atributo error.
     */
    public boolean isError() {
        return error;
    }

    /**
     * Permite setear el valor del atributo error.
     *
     * @param error nuevo valor para el atributo error.
     */
    public void setError(boolean error) {
        this.error = error;
    }
    
    
    public abstract void setInParameters();
    
    public abstract void setOutParameters();
    
    public abstract E executeSP(HashMap<String, Object> parameters);
    
    
}
