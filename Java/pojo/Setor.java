package pojo;

import java.util.ArrayList;
import java.util.List;

public class Setor {

	protected long codSetor;
	private String nomeSetor;
	private double salario;
	private List<Funcionario> listaFuncionario;

	public Setor() {
		this.listaFuncionario = new ArrayList<Funcionario>();
	}

	public Setor(long codSetor, String nomeSetor, double salario, List<Funcionario> listaFuncionario) {
		this.codSetor = codSetor;
		this.nomeSetor = nomeSetor;
		this.salario = salario;
		this.listaFuncionario = listaFuncionario;
	}

	public long getCodSetor() {
		return codSetor;
	}

	public void setCodSetor(long codSetor) {
		this.codSetor = codSetor;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	public String getNomeSetor() {
		return nomeSetor;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}

}
