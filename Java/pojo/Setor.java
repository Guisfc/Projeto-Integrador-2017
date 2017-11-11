package pojo;

public class Setor {

	private long id_setor;
	private String tipo;
	private double salario;

	public Setor() {

	}

	public Setor(long id_setor, String tipo, double salario) {
		this.id_setor = id_setor;
		this.tipo = tipo;
		this.salario = salario;
	}

	public long getId_setor() {
		return id_setor;
	}

	public void setId_setor(long id_setor) {
		this.id_setor = id_setor;
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
