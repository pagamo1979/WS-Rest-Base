package cl.ws.util;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;



public class MessagesUtil {
	
	private static Logger LOGGER = Logger.getLogger(MessagesUtil.class);
	
	 /**
     * Permite obtener el texto asociado a la clave
     * en un archivo de recursos especificado.
     *
     * @param msgKey
     *           Clave de la etiqueta.
     * @param resource
     *           Alias del archivo de recursos.
     * @return El texto paramítrico obtenido.
     */
	static Properties prop = null;
    public static String getGenericText(String msgKey) {

        
        //ResourceBundle bundle = ResourceBundle.getBundle("");
        
    	 
      
    		try {
    			if(prop == null) {
    				prop = new Properties();
	    			File file = new File("application.properties");
	    			FileInputStream input;
	    			System.out.println("path:"+file.getAbsolutePath());
	    			if(file.exists()) {
	    				 input = new FileInputStream(file);
	    			}
	    			else {
		    			String pathLocal ="/Users/pablo/eclipse-workspace/WS-Rest-Base/src/main/resources/application.properties";
		    		     file = new File(pathLocal);
		    			 input = new FileInputStream(file);
	    			}
	    			// load a properties file
	    			prop.load(input);
    			}
    		}catch(Exception e) {
    			LOGGER.error("",e);
    			
    		}
    		System.out.println("msgKey:"+prop.getProperty(msgKey));
        return prop.getProperty(msgKey);

    }
    
   
}
