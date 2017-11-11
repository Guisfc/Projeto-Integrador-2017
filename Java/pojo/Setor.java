package pojo;

public class Setor {

	private long idSetor;
	private String tipo;
	private double salario;

	public Setor() {

	}

	public Setor(long idSetor, String tipo, double salario) {
		this.idSetor = idSetor;
		this.tipo = tipo;
		this.salario = salario;
	}

	public long getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(long idSetor) {
		this.idSetor = idSetor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
