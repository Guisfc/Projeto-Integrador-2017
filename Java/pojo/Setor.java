package pojo;

public class Setor {

	private long codSetor;
	private String setor;
	private double salario;

	public Setor() {

	}

	public Setor(long codSetor, String setor, double salario) {
		this.codSetor = codSetor;
		this.setor = setor;
		this.salario = salario;
	}

	public long getCodSetor() {
		return codSetor;
	}

	public void setCodSetor(long codSetor) {
		this.codSetor = codSetor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
