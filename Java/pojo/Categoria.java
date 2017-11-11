package pojo;

public class Categoria {

	// ATRIBUTOS
	private int idCategoria;
	private String tipo;
	private String descricao;
	private double valorDiaria;

	// CONSTRUTORES
	public Categoria() {

	}

	public Categoria(int idCategoria, String tipo, String descricao, double valorDiaria) {
		this.idCategoria = idCategoria;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valorDiaria = valorDiaria;
	}

	// MÉTODOS
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

}
