package pojo;

import java.util.ArrayList;
import java.util.List;

public class Quarto {

	private long idQuarto;
	private boolean disponivel;
	private boolean limpo;
	private List<Reserva> listareservas;

	public Quarto() {
		this.listareservas = new ArrayList<Reserva>();
	}

	public Quarto(long idQuarto, boolean disponivel, boolean limpo) {
		super();
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

	public List<Reserva> getListareservas() {
		return listareservas;
	}

	public void setListareservas(List<Reserva> listareservas) {
		this.listareservas = listareservas;
	}

}