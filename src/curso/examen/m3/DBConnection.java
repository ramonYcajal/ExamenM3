package curso.examen.m3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	private static Connection conn = null;

	private DBConnection() {
		String url = "jdbc:mysql://localhost:3306/mail";
		String user = "root";
		String pass = "";
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, pass);
				System.out.println("conectado a la base de datos");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}
 
	public static Connection getConnection() {
		if (conn == null) {
			new DBConnection();
		}
		return conn;
	}
	public static void closeConnection() {
		try {
			System.out.println("cerrada");
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
