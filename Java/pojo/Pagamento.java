package pojo;

public class Pagamento {

	// ATRIBUTOS
	private long codPagamento;
	private double valorEntrada;
	private double valorTotal;

	// CONSTRUTORES
	public Pagamento() {

	}

	public Pagamento(long codPagamento, double valorEntrada, double valorTotal) {
		this.codPagamento = codPagamento;
		this.valorEntrada = valorEntrada;
		this.valorTotal = valorTotal;
	}

	// MÉTODOS
	public long getCodPagamento() {
		return codPagamento;
	}

	public void setCodPagamento(long codPagamento) {
		this.codPagamento = codPagamento;
	}

	public double getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
