package pojo;

import java.sql.Date;

public class Reserva {

	// ATRIBUTOS
	private long idReserva;
	private java.sql.Date dataEntrada;
	private java.sql.Date dataSaida;
	private Cliente cliente;
	private Quarto quarto;
	//

	// CONSTRUTORES
	public Reserva() {
		this.cliente = new Cliente();
		this.quarto = new Quarto();
	}

	public Reserva(long idReserva, Date dataEntrada, Date dataSaida, Cliente cliente, Quarto quarto) {
		this.idReserva = idReserva;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.cliente = cliente;
		this.quarto = quarto;
	}

	// MÉTODOS
	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date setDataEntrada(Date dataEntrada) {
		return this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

}
