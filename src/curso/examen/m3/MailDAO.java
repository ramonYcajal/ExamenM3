package curso.examen.m3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MailDAO {
	String insertMailSend = "insert into mailsend (destinatario, email.provincia,cuerpo)values(?,?,?,?)";
/**
 * 
 * @param email recibe un objeto de tipo email
 * lo inserta en la base de datos
 */
	public void insert(Email email) {

		Connection conn = DBConnection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(insertMailSend);
			ps.setString(1, email.getDestinatario());
			ps.setString(2, email.getEmail());
			ps.setString(3, email.getProvincia());
			ps.setString(4, email.getCuerpo());
			ps.setString(5, email.getAsunto());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
