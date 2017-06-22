package cl.bice.integracion.movil.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
	
    /**
     * Archivo de propiedades Actimize.
     */
    private static final String APISERVIPAG_PROPERTIES =
        "/application.properties";
    
    
    /**
     * Logger de la clase.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(Utils.class);
    
	 public void validaSSL(String uri){
		 
	        String urlString = "https://desaservipag.anticipa.cl/";

	        // if any url specified, use that instead:

	        if(uri.length() > 0) {
	            urlString = uri;
	        }
	        System.out.println("Connecting to " + urlString + "...");
	       
	        try {
	            // convert user string to URL object

	            URL url = new URL(urlString);

	            // connect!

	            URLConnection cnx = url.openConnection();
	            cnx.connect();

	            // read the page returned

	            InputStream ins = cnx.getInputStream();
	            BufferedReader in = new BufferedReader(new InputStreamReader(ins));
	            String curline;
	            while( (curline = in.readLine()) != null ) {
	                System.out.println(curline);
	            }

	            // close the connection

	            ins.close();
	        }
	        catch(Throwable t) {
	        	
	            t.printStackTrace();
	            
	        }

		 
	 }
	 
	 static Properties prop = null;
	    /**
	     * Obtiene Propiedades para consultar tarjetas.
	     * @param propertyName Nombre del archivo properties
	     * @return valor de la propiedad.
	     */
	    public static String getApiServipagProperty(String propertyName) {
	        
	        String value = "";
	        try {
	        	
	        	if (prop == null){
	        		prop = new Properties();
	        	
	            prop.load(Utils.class
	                .getResourceAsStream(APISERVIPAG_PROPERTIES));
	        	}
	            value = prop.getProperty(propertyName);
	            
	        	
	        } catch (FileNotFoundException e) {
	            LOGGER.error("Error al cargar archivo de propiedades.\n" + e);
	        } catch (IOException e) {
	            LOGGER.error("Error al obtenener properties.\n" + e);
	        }
	        return value;
	    }
	    
	    

}
