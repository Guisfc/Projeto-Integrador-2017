package pojo;

public class Limpeza {

	private long codLimpeza;
	private String dataHora;
	private String descricao;
	private long idFuncionario;
	private long idQuarto;

	public Limpeza() {

	}

	public Limpeza(long codLimpeza, String dataHora, String descricao, long idFuncionario, long idQuarto) {
		this.codLimpeza = codLimpeza;
		this.dataHora = dataHora;
		this.descricao = descricao;
		this.idFuncionario = idFuncionario;
		this.idQuarto = idQuarto;
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

	public long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public long getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(long idQuarto) {
		this.idQuarto = idQuarto;
	}

}
