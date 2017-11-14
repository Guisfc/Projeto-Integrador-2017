package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import pojo.Pagamento;

public class PagamentoDAO {

	Conexao conexao;

	public PagamentoDAO() {
		this.conexao = new Conexao("localhost", "bd_hotel", "root", "");
	}

	// SALVAR PAGAMENTO
	public Pagamento salvar(Pagamento pagamento) {
		String sql = "INSERT INTO pagamento VALUES(null, ?, ?)";
		this.conexao.abrirConexao();
		try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setDouble(1, pagamento.getValorEntrada());
			stmt.setDouble(2, pagamento.getValorTotal());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				pagamento.setCodPagamento(rs.getLong(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return pagamento;

	}

	// EDITAR PAGAMENTO
	public Pagamento editar(Pagamento pagamento) {
		String sql = "UPDATE pagamento SET valor_entrada=?, valor_total=? WHERE cod_pagamento=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
			stmt.setDouble(1, pagamento.getValorEntrada());
			stmt.setDouble(2, pagamento.getValorTotal());
			stmt.setLong(3, pagamento.getCodPagamento());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return pagamento;
	}

	// DELETAR PAGAMENTO POR CÓDIGO
	public void deletarPorId(long id) {
		String sql = "DELETE FROM pagamento WHERE cod_pagamento=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}

	}

	// BUSCAR PAGAMENTO POR CODIGO
	public Pagamento buscarPorId(long id) {
		Pagamento pagamento = null;
		String sql = "SELECT * FROM pagamento WHERE cod_pagamento = ?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				pagamento = new Pagamento();
				pagamento.setCodPagamento(rs.getLong("cod_pagamento"));
				pagamento.setValorEntrada(rs.getDouble("valor_entrada"));
				pagamento.setValorTotal(rs.getDouble("valor_total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return pagamento;
	}

	// BUSCAR TODOS OS PAGAMENTOS
	public List<Pagamento> buscarTodos() {
		List<Pagamento> listaPagamentos = new ArrayList<Pagamento>();
		String sql = "SELECT * FROM Pagamento";
		this.conexao.abrirConexao();
		try {
			PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pagamento pagamento = new Pagamento();
				pagamento.setCodPagamento(rs.getLong("cod_pagamento"));
				pagamento.setValorEntrada(rs.getDouble("valor_entrada"));
				pagamento.setValorTotal(rs.getDouble("valor_total"));
				listaPagamentos.add(pagamento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPagamentos;
	}
}
