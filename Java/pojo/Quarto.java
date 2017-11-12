package pojo;

public class Quarto {

	private long idQuarto;
	private boolean disponivel;
	private boolean limpo;

	public Quarto() {
		
	}

	public Quarto(long idQuarto, boolean disponivel, boolean limpo) {
		this.idQuarto = idQuarto;
		this.disponivel = disponivel;
		this.limpo = limpo;
	}

	public long getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(long idQuarto) {
		this.idQuarto = idQuarto;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean isLimpo() {
		return limpo;
	}

	public void setLimpo(boolean limpo) {
		this.limpo = limpo;
	}

}
