package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Categoria;


import pojo.Quarto;

public class QuartoDAO {

	Conexao conexao;

	public QuartoDAO() {
		this.conexao = new Conexao("localhost", "bd_hotel", "root", "");
	}

	public Quarto salvar(Quarto quarto) {
		String sql = "INSERT INTO quarto (id_quarto, disponivel, limpo, id_categoria) VALUES (null,?,?,?)";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, quarto.getStatusDisponivel());
			stmt.setInt(2, quarto.getStatusLimpeza());
			stmt.setLong(3, quarto.getCategoria().getIdCategoria());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				quarto.setIdQuarto(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return quarto;
	}

	public void deletar(long idQuarto) {
		String sql = "DELETE FROM quarto WHERE id_quarto = ?";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			stmt.setLong(1, idQuarto);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
	}

	public Quarto editar(Quarto quarto) {
		String sql = "UPDATE quarto SET disponivel=?, limpo=?, id_categoria=? WHERE id_quarto=?";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			stmt.setInt(1, quarto.getStatusDisponivel());
			stmt.setInt(2, quarto.getStatusLimpeza());
			stmt.setLong(3, quarto.getCategoria().getIdCategoria());
			stmt.setLong(4, quarto.getIdQuarto());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return quarto;
	}

	public List<Quarto> pesquisar() {
		List<Quarto> listaQuarto = new ArrayList<Quarto>();
                String sql = "SELECT id_quarto, disponivel, limpo, tipo FROM quarto INNER JOIN categoria ON quarto.id_categoria=categoria.id_categoria";
		//String sql = "SELECT * FROM quarto";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Quarto quarto = new Quarto();
				quarto.setIdQuarto(rs.getLong("id_quarto"));
				quarto.setStatusDisponivel(rs.getInt("disponivel"));
				quarto.setStatusLimpeza(rs.getInt("limpo"));
                                
                                Categoria categoria = new Categoria();
				categoria.setTipo(rs.getString("tipo"));
                                
                                quarto.setCategoria(categoria);
				listaQuarto.add(quarto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return listaQuarto;
	}

}
