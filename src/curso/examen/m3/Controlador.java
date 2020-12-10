package curso.examen.m3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.examen.m3.libreria.Util;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Util util=new Util();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * <p>carga la página y va directamente al get para cargar provincias
	 * al tener el urlpattern del servlet vacío, entrará directamente al método get</p>
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: completar
		Util util=new Util();
		ArrayList<String> listadoProvincias =util.obtenerListadoProvincias();
		
		request.getSession().setAttribute("listadoProvincias", listadoProvincias);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 
	 * @param nombreDestinatario: el nombre del destinatario del correo electrónico
	 * @param mailDestino: cuenta de email para enviar el mensaje
	 * @param provincia: la provincia del destinatario
	 * @param cuerpoDelmensaje: el desarrollo del tema a tratar
	 * @param asunto: el tema a tratar
	 * 
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: completar
		String nombreDestinatario=request.getParameter("username");
		String emailDestino=request.getParameter("email");
		String provincia=request.getParameter("provincias");
		String cuerpoDelmensaje=request.getParameter("cuerpo");		
		String asunto=nombreDestinatario+" - "+provincia;
		Email email=new Email(nombreDestinatario,provincia,asunto,cuerpoDelmensaje,emailDestino);
		MailDAO maildao=new MailDAO();
		maildao.insert(email);
		Properties properties=new Properties();
		properties.load(new FileInputStream("assets/email.properties"));
		EmailController emc=new EmailController(email);
		try {
			util.enviarEmail(properties.getProperty("user"), properties.getProperty("pass"), emailDestino, asunto, cuerpoDelmensaje);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
