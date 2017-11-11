package pojo;

public class Reserva {

	// ATRIBUTOS
	private long idReserva;
	private String dataEntrada;
	private String dataSaida;

	// CONSTRUTORES
	public Reserva() {

	}

	public Reserva(long idReserva, String dataEntrada, String dataSaida) {
		this.idReserva = idReserva;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	// MÉTODOS
	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

}
