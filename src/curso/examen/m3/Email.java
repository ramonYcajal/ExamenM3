package curso.examen.m3;

public class Email {
	private String destinatario;
	private String provincia;
	private String asunto;
	private String cuerpo;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Email(String destinatario, String provincia, String asunto, String cuerpo, String email) {
		super();
		this.destinatario = destinatario;
		this.provincia = provincia;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
		this.email = email;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
