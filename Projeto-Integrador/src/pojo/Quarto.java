package pojo;

import java.util.ArrayList;
import java.util.List;

public class Quarto {

    private long idQuarto;
    private boolean disponivel; //MOSTRA PRA PESSOA
    private boolean limpo; //MOSTRA PRA PESSOA
    private int statusDisponivel;//BANCO
    private int statusLimpeza;//BANCO
    private Categoria categoria;
    private List<Reserva> listaReservas;
    private List<Limpeza> listaLimpeza;

    public Quarto() {
        this.listaReservas = new ArrayList<Reserva>();
        this.listaLimpeza = new ArrayList<Limpeza>();
        this.statusDisponivel = 1;
        this.statusLimpeza = 1;
    }

    public Quarto(long idQuarto, boolean disponivel, boolean limpo, Categoria categoria, List<Reserva> listaReservas, List<Limpeza> listaLimpeza) {
        this.idQuarto = idQuarto;
        this.disponivel = disponivel;
        this.limpo = limpo;
        this.categoria = categoria;
        this.listaReservas = listaReservas;
        this.listaLimpeza = listaLimpeza;
    }

    public long getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public boolean isDisponivel() {
        if (getStatusDisponivel() == 1) {
            disponivel = true;
        } else {
            disponivel = false;
        }
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isLimpo() {
        return limpo;
    }

    public void setLimpo(boolean limpo) {
        this.limpo = limpo;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public List<Limpeza> getListaLimpeza() {
        return listaLimpeza;
    }

    public void setListaLimpeza(List<Limpeza> listaLimpeza) {
        this.listaLimpeza = listaLimpeza;
    }

    public int getStatusDisponivel() {
        return statusDisponivel;
    }

    public void setStatusDisponivel(int statusDisponivel) {
        this.statusDisponivel = statusDisponivel;
        if (statusDisponivel == 1) {
            setDisponivel(true);
        } else {
            setDisponivel(false);
        }

    }

    public int getStatusLimpeza() {
        return statusLimpeza;
    }

    public void setStatusLimpeza(int statusLimpeza) {
        this.statusLimpeza = statusLimpeza;
        if (statusLimpeza == 1) {
            setLimpo(true);
        } else {
            setLimpo(false);
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
