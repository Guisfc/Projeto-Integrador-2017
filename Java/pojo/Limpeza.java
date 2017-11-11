package pojo;

public class Limpeza {

	private long codLimpeza;
	private String dataHora;
	private String descricao;

	public Limpeza() {

	}

	public Limpeza(long codLimpeza, String dataHora, String descricao) {
		this.codLimpeza = codLimpeza;
		this.dataHora = dataHora;
		this.descricao = descricao;
	}

	public long getCodLimpeza() {
		return codLimpeza;
	}

	public void setCodLimpeza(long codLimpeza) {
		this.codLimpeza = codLimpeza;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
