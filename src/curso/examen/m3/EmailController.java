package curso.examen.m3;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailController {
 private Email email;
public EmailController(Email email) {

this.email=email;

}
public void sendEmail() {
			try {
				// Propiedades de la conexion
				Properties properties=new Properties();
				try {
					properties.load(new FileInputStream("assets/email.properties"));
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Properties prop = new Properties();
				// Nombre del servidor de salida
				prop.setProperty("mail.smtp.host", "smtp.gmail.com");
				// Habilitamos TLS
				prop.setProperty("mail.smtp.starttls.enable", "true");
				// Indicamos el puerto
				prop.setProperty("mail.smtp.port", "587");
				// Indicamos el usuario
				prop.setProperty("mail.smtp.user", properties.getProperty("user"));
				// Indicamos que requiere autenticación
				prop.setProperty("mail.smtp.auth", "true");
				String pwd=properties.getProperty("pass");
				// Creamos un objeto sesion
				Session sesion = Session.getDefaultInstance(prop);
				//TODO
				sesion.setDebug(true);
				// Creamos un objeto mensaje a traves de la sesion
				MimeMessage mensaje = new MimeMessage(sesion);
				
				// Indicamos la cuenta desde la que se va a enviar
				mensaje.setFrom(new InternetAddress("yo@yo.com"));

				// Añadimos el recipiente al mensaje al que va a ir dirigido el mensaje
				mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getDestinatario()));

				// Creamos el asunto del mensaje
				mensaje.setSubject(email.getAsunto());

				// Creamos el cuerpo del mensaje
				mensaje.setText(email.getCuerpo());

				
				// Utilizamos un objeto transport para hacer el envio indicando el protocolo
				Transport t = sesion.getTransport("smtp");
				// Hacemos la conexion
				t.connect(properties.getProperty("user"), pwd);
				// Enviamos el mensaje
				t.sendMessage(mensaje, mensaje.getAllRecipients());

				// Cerramos la conexion
				t.close();

			} catch (AddressException ex) {
				Logger.getLogger(EmailController.class.getName()).log(Level.SEVERE, null, ex);
			} catch (MessagingException ex) {
				Logger.getLogger(EmailController.class.getName()).log(Level.SEVERE, null, ex);
			}

		}

}
