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
	private long idFuncionario;
	private long idQuarto;

	public Limpeza() {

	}

	public Limpeza(long codLimpeza, String data, String descricao, long idFuncionario, long idQuarto) {
		this.codLimpeza = codLimpeza;
		setData(data);
		this.descricao = descricao;
		this.idFuncionario = idFuncionario;
		this.idQuarto = idQuarto;
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

	public long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public long getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(long idQuarto) {
		this.idQuarto = idQuarto;
	}

	public Date getDataSql() {
		return dataSql;
	}

	public void setDataSql(Date dataSql) {
		this.dataSql = dataSql;
	}

}
