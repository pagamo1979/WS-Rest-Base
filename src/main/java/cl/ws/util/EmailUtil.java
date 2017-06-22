package cl.ws.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import cl.ws.vo.Entrada1;


/**
 * Clase utilitaria para el envio de emails.
 *
 * @author Bruno Chandía.
 */
public final class EmailUtil {

    /**
     * Log de la clase.
     */
    private static final Logger LOGGER = Logger.getLogger(EmailUtil.class);

    /**
     * Nombre del archivo de propiedades.
     */
    private static final String EMAIL_RESOURCE_KEY = "config";
    /**
     * Clave del host de correo.
     */
    private static final String KEY_HOST = "SERVIDOR_CORREO";

    /**
     * Clave del puerto de correo.
     */
    private static final String KEY_PORT = "PUERTO_CORREO";

    /**
     * Si aplica ssl true o false.
     */
    private static final String KEY_SSL = "HABILITAR_SSL_CORREO";

    /**
     * Clave del usuario de la cuenta de correo.
     */
    private static final String KEY_USUARIO = "USUARIO_CORREO";

    /**
     * Clave del password de la cuenta de correo.
     */
    private static final String KEY_PASSWORD = "PASS_CORREO";

    /**
     * Clave de la cabecera del cuerpo html del correo.
     */
    private static final String KEY_HTML_HEADER = "CABECERA_HTML";

    /**
     * Token separador de los parímetros del cuerpo del mensaje.
     */
    private static final String KEY_TOKEN = "#";

    /**
     * Clave del contenido principal.
     */
    private static final String KEY_CONTENIDO_PRINCIPAL = "CONTENIDO_PRINCIPAL";

    /**
     * Clave de la firma.
     */
    private static final String KEY_FIRMA = "FIRMA";

    /**
     * Sufijo de la clave para obtener el remitente.
     */
    private static final String SUFIJO_RTTE = "_RTTE";

    /**
     * Sufijo de la clave para obtener el destinatario.
     */
    private static final String SUFIJO_DESTINATARIO = "_DESTINATARIO";

    /**
     * Sufijo de la clave para obtener el contenido del email.
     */
    private static final String SUFIJO_CONTENIDO = "_CONTENIDO";

    /**
     * Sufijo de la clave para obtener el título del email.
     */
    private static final String SUFIJO_TITULO = "_TITULO";

    /**
     * Clave del la plantilla del email.
     */
    private static final String PLANTILLA_HTML = "PLANTILLA_HTML";

    /**
     * Clave de la firma del email.
     */
    private static final String FIRMA_HTML = "FIRMA_HTML";

    /**
     * Clave del email de tipo VALIDA EMPRESA.
     */
    public static final String
                       TIPO_EMAIL_CONTACTO = "CONTACTO";

    /**
     * Clave para enviar el destinatario por defecto.
     */
    public static final String PARAM_DESTINATARIO = "PARAMDTN";

    /**
     * Clave para enviar el remitente por defecto.
     */
    public static final String PARAM_RTTE = "PARAMRTTE";
    /**
     * Separador.
     */
    public static final String TOKEN_SPLIT_PROPERTIES = ";";


    /**
     * Constructor privado de la clase.
     */
    private EmailUtil() {

    }

    /**
     * Permite enviar emails definiendo su tipo y parímetros.
     *
     * @param tipo
     *            Tipo de email a enviar.
     * @param parametros
     *            Parímetros a utilizar en el envío del email.
     */
    public static void enviarEmail(Entrada1 parametros) {
      	String tipo ="";
        String destinatario =  parametros.getToMail();
        String remitente = parametros.getFromEmail();

        if (destinatario == null) {
            destinatario =
                    MessagesUtil.getGenericText(tipo + SUFIJO_DESTINATARIO
                            );
        }
        if (remitente == null) {
            remitente =
                    MessagesUtil.getGenericText(KEY_USUARIO);
        }

        HashMap<String, String> paramEmail = new HashMap<String, String>();

        paramEmail.put("servidor", MessagesUtil.getGenericText(
                KEY_HOST));
        paramEmail.put("puerto",
                MessagesUtil.getGenericText(KEY_PORT));
        paramEmail.put("ssl",
                MessagesUtil.getGenericText(KEY_SSL));
        paramEmail.put("emailFrom", remitente);
        paramEmail.put("emailTo", destinatario);
        paramEmail.put("subject", parametros.getToSubject());
        
        
        LOGGER.info("[enviarEmail()] Mail destino: " + destinatario);
        String cabecera =
                MessagesUtil
                        .getGenericText(KEY_HTML_HEADER);
        String plantilla =
                cabecera
                        + MessagesUtil.getGenericText(PLANTILLA_HTML
                             );

        String firma =
                MessagesUtil.getGenericText(FIRMA_HTML);

        String contenido =
                MessagesUtil.getGenericText(tipo + SUFIJO_CONTENIDO
                        );

          contenido = parametros.getBodyMsg();
                    

        plantilla =
                plantilla.replaceAll(KEY_TOKEN + KEY_CONTENIDO_PRINCIPAL
                        + KEY_TOKEN, contenido);
        plantilla =
                plantilla.replaceAll(KEY_TOKEN + KEY_FIRMA + KEY_TOKEN, firma);
        paramEmail.put("contenido", plantilla);
        paramEmail.put("usuario",
                MessagesUtil.getGenericText(KEY_USUARIO));
        paramEmail.put("password",
                MessagesUtil.getGenericText(KEY_PASSWORD));

        try {
            sendGmailConImagenes(paramEmail);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(e);
        } catch (MessagingException e) {
            LOGGER.error(e);
        }

    }

    /**
     * Permite realizar el envio de emails.
     *
     * @param parametros
     *            Parametros a utilizar en el envio del email.
     * @throws MessagingException
     *             Si ocurre un error al enviar el email.
     * @throws UnsupportedEncodingException
     *             Si el encoding no es soportado.
     */
    public static void send(Map<String, String> parametros)
            throws MessagingException, UnsupportedEncodingException {

        LOGGER.info("[send] Enviando mail...");
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", parametros.get("servidor"));
        props.setProperty("mail.user", parametros.get("usuario"));
        props.setProperty("mail.password", parametros.get("password"));

        Session mailSession = Session.getDefaultInstance(props, null);
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(parametros.get("subject"));
        message.setFrom(new InternetAddress(parametros.get("emailFrom")));
        message.setContent(parametros.get("contenido"), "text/html");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                parametros.get("emailTo")));

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }

    /**
     * Permite realizar el envio de emails utilizando servidor de Google.
     *
     * @param parametros
     *            Parímetros a utilizar en el envío del email.
     * @throws MessagingException
     *             Si ocurre un error al enviar el email.
     * @throws UnsupportedEncodingException
     *             Si el encoding no es soportado.
     */
    public static void sendGmailConImagenes(Map<String, String> parametros)
            throws MessagingException, UnsupportedEncodingException {

        final String username = parametros.get("usuario");
        final String password = parametros.get("password");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", parametros.get("ssl"));
        props.put("mail.smtp.host", parametros.get("servidor"));
        props.put("mail.smtp.port", parametros.get("puerto"));
        props.put("mail.smtps.localhost","localhost");
        props.put("mail.debug","true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected
                    PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(parametros.get("emailFrom")));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(parametros.get("emailTo")));
            message.setSubject(parametros.get("subject"));

            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();

            String htmlText = parametros.get("contenido");
            messageBodyPart.setContent(htmlText, "text/html");

            // add it
            multipart.addBodyPart(messageBodyPart);


            // header
            message.setHeader("Content-Type", "text/html; charset=\"utf-8\"");

            // put everything together
            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Mail Enviado...");
            LOGGER.info("Mail Enviado...");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}

