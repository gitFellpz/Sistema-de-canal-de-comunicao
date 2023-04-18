package entidades;

public class Mensagem {
	
	private String nome;
	private String emailTelefone;
	private String motivoContato;
	private String mensagem;
	
	
	public Mensagem(String nome, String emailTelefone, String motivoContato, String mensagem) {
		this.nome = nome;
		this.emailTelefone = emailTelefone;
		this.motivoContato = motivoContato;
		this.mensagem = mensagem;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmailTelefone() {
		return emailTelefone;
	}
	public void setEmailTelefone(String emailTelefone) {
		this.emailTelefone = emailTelefone;
	}
	public String getMotivoContato() {
		return motivoContato;
	}
	public void setMotivoContato(String motivoContato) {
		this.motivoContato = motivoContato;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "Mensagem [nome=" + nome + ", emailTelefone=" + emailTelefone + ", motivoContato=" + motivoContato
				+ ", mensagem=" + mensagem + "]";
	}

}
