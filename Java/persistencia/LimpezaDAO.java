package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Limpeza;

public class LimpezaDAO {

	Conexao conexao;

	public LimpezaDAO() {
		this.conexao = new Conexao("localhost", "bd_hotel", "root", "root");
	}

	public Limpeza salvar(Limpeza limpeza) {
		String sql = "INSERT INTO limpeza (cod_limpeza, data_hora, descricao, id_funcionario, id_quarto) VALUES (null,?,?,?,?)";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			stmt.setString(1, limpeza.getDataHora());
			stmt.setString(2, limpeza.getDescricao());
			stmt.setLong(3, limpeza.getIdFuncionario());
			stmt.setLong(4, limpeza.getIdQuarto());
			stmt.executeUpdate();
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
			stmt.setString(1, limpeza.getDataHora());
			stmt.setString(2, limpeza.getDescricao());
			stmt.setLong(3, limpeza.getIdFuncionario());
			stmt.setLong(4, limpeza.getIdQuarto());
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
		String sql = "SELECT * FROM limpeza";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Limpeza limpeza = new Limpeza();
				limpeza.setCodLimpeza(rs.getLong("cod_limpeza"));
				limpeza.setDataHora(rs.getString("data_hora"));
				limpeza.setDescricao(rs.getString("descricao"));
				limpeza.setIdFuncionario(rs.getLong("id_funcionario"));
				limpeza.setIdQuarto(rs.getLong("id_quarto"));

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
