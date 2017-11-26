package pojo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	// ATRIBUTOS
	private int idCategoria;
	private String tipo;
	private String descricao;
	private double valorDiaria;
	private List<Quarto> listaQuartos;

	// CONSTRUTORES
	public Categoria() {
		this.listaQuartos = new ArrayList<Quarto>();
	}

	public Categoria(int idCategoria, String tipo, String descricao, double valorDiaria, List<Quarto> listaQuartos) {
		this.idCategoria = idCategoria;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valorDiaria = valorDiaria;
                this.listaQuartos = listaQuartos;
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

	public List<Quarto> getListaQuartos() {
		return listaQuartos;
	}

	public void setListaQuartos(List<Quarto> listaQuartos) {
		this.listaQuartos = listaQuartos;
	}

}