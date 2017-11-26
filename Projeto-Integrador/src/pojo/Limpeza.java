package pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Limpeza {

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private long codLimpeza;
    private String data;
    private Date dataSql;
    private String descricao;

    private Funcionario funcionario;
    private Quarto quarto;

    public Limpeza() {

    }

    public Limpeza(long codLimpeza, String data, String descricao, Funcionario funcionario, Quarto quarto) {
        this.codLimpeza = codLimpeza;
        setData(data);
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.quarto = quarto;
    }

    public long getCodLimpeza() {
        return codLimpeza;
    }

    public void setCodLimpeza(long codLimpeza) {
        this.codLimpeza = codLimpeza;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        try {
            this.dataSql = format.parse(data); //CONVERTE STRING PARA DATE
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataSql() {
        return dataSql;
    }

    public void setDataSql(Date dataSql) {
        this.dataSql = dataSql;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

}
