package pojo;

public class Limpeza {

	private long cod_limpeza;
	private String data_hora;
	private String descricao;

	public Limpeza() {

	}

	public Limpeza(long cod_limpeza, String data_hora, String descricao) {
		this.cod_limpeza = cod_limpeza;
		this.data_hora = data_hora;
		this.descricao = descricao;
	}

	public long getCod_limpeza() {
		return cod_limpeza;
	}

	public void setCod_limpeza(long cod_limpeza) {
		this.cod_limpeza = cod_limpeza;
	}

	public String getData_hora() {
		return data_hora;
	}

	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
