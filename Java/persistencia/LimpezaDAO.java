package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Funcionario;


import pojo.Limpeza;
import pojo.Quarto;

public class LimpezaDAO {

	Conexao conexao;

	public LimpezaDAO() {
		this.conexao = new Conexao("localhost", "bd_hotel", "root", "");
	}

	public Limpeza salvar(Limpeza limpeza) {
		String sql = "INSERT INTO limpeza (cod_limpeza, data_hora, descricao, id_funcionario, id_quarto) VALUES (null,?,?,?,?)";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
			stmt.setTimestamp(1, new java.sql.Timestamp(limpeza.getDataSql().getTime()));	//(1, new java.sql.Date(limpeza.getDataSql().getTime());  << SOMENTE DATA
			stmt.setString(2, limpeza.getDescricao());
			stmt.setLong(3, limpeza.getFuncionario().getIdFuncionario());
			stmt.setLong(4, limpeza.getQuarto().getIdQuarto());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				limpeza.setCodLimpeza(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return limpeza;
	}

	public void deletar(long codLimpeza) {
		String sql = "DELETE FROM limpeza WHERE cod_limpeza = ?";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			stmt.setLong(1, codLimpeza);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
	}

	public Limpeza editar(Limpeza limpeza) {
		String sql = "UPDATE limpeza SET data_hora=?, descricao=?, id_funcionario=?, id_quarto=? WHERE cod_limpeza=?";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			stmt.setTimestamp(1, new java.sql.Timestamp(limpeza.getDataSql().getTime()));
			stmt.setString(2, limpeza.getDescricao());
			stmt.setLong(3, limpeza.getFuncionario().getIdFuncionario());
			stmt.setLong(4, limpeza.getQuarto().getIdQuarto());
			stmt.setLong(5, limpeza.getCodLimpeza());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return limpeza;
	}

	public List<Limpeza> pesquisar() {
		List<Limpeza> listaLimpeza = new ArrayList<Limpeza>();
                String sql = "SELECT cod_limpeza, data_hora, descricao, nome, sobrenome, id_quarto FROM limpeza INNER JOIN funcionario ON limpeza.id_funcionario=funcionario.id_funcionario";
		//String sql = "SELECT * FROM limpeza";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Limpeza limpeza = new Limpeza();
				limpeza.setCodLimpeza(rs.getLong("cod_limpeza"));
				limpeza.setDataSql(rs.getTimestamp("data_hora"));
				limpeza.setDescricao(rs.getString("descricao"));
                                
                                Funcionario funcionario = new Funcionario();
                                funcionario.setNome(rs.getString("nome"));
                                funcionario.setSobrenome(rs.getString("sobrenome"));
                                
                                Quarto quarto = new Quarto();
				quarto.setIdQuarto(rs.getLong("id_quarto"));

                                limpeza.setFuncionario(funcionario);
                                limpeza.setQuarto(quarto);
				listaLimpeza.add(limpeza);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return listaLimpeza;
	}

}
