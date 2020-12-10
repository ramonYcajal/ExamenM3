package curso.examen.m3;

public class MailPOJO {
	private String destinatario;
	private String email;
	private String provincia;
	private String cuerpo;
	public MailPOJO(String destinatario, String email, String provincia, String cuerpo) {
		super();
		this.destinatario = destinatario;
		this.email = email;
		this.provincia = provincia;
		this.cuerpo = cuerpo;
	}
	public MailPOJO() {
		super();
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	
}
