package pojo;

public class Quarto {

	private long id_quarto;
	private boolean disponivel;
	private boolean limpo;

	public Quarto() {

	}

	public Quarto(long id_quarto, boolean disponivel, boolean limpo) {
		this.id_quarto = id_quarto;
		this.disponivel = disponivel;
		this.limpo = limpo;
	}

	public long getId_quarto() {
		return id_quarto;
	}

	public void setId_quarto(long id_quarto) {
		this.id_quarto = id_quarto;
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
