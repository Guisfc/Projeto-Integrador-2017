package pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Reserva {
    
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    // ATRIBUTOS
    private long idReserva;
    private Date dataSqlEntrada;
    private Date dataSqlSaida;
    private String dataEntrada;
    private String dataSaida;

    private Cliente cliente;
    private Quarto quarto;
    //

    // CONSTRUTORES
    public Reserva() {
        this.cliente = new Cliente();
        this.quarto = new Quarto();
    }

    public Reserva(long idReserva, String dataEntrada, String dataSaida, Cliente cliente, Quarto quarto) {
        this.idReserva = idReserva;
        setDataEntrada(dataEntrada);
        setDataSaida(dataSaida);
        this.dataSaida = dataSaida;
        this.cliente = cliente;
        this.quarto = quarto;
    }

    // M�TODOS
    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
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

    public Date getDataSqlEntrada() {
        return dataSqlEntrada;
    }

    public void setDataSqlEntrada(Date dataSqlEntrada) {
        this.dataSqlEntrada = dataSqlEntrada;
    }

    public Date getDataSqlSaida() {
        return dataSqlSaida;
    }

    public void setDataSqlSaida(Date dataSqlSaida) {
        this.dataSqlSaida = dataSqlSaida;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
        try {
            this.dataSqlEntrada = format.parse(dataEntrada);
        } catch (ParseException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
        try {
            this.dataSqlSaida = format.parse(dataSaida);
        } catch (ParseException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}