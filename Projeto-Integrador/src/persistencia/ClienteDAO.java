package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Cliente;

public class ClienteDAO {

	Conexao conexao;

	public ClienteDAO() {
		this.conexao = new Conexao("localhost", "bd_hotel", "root", "");
	}

	// CADASTRAR CLIENTE
	public Cliente salvar(Cliente cliente) {
		String sql = "INSERT INTO cliente VALUES(null, ?, ?, ?, ?, ?, ?)";
		conexao.abrirConexao();

		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSobrenome());
			stmt.setString(3, cliente.getLogin());
			stmt.setString(4, cliente.getSenha());
			stmt.setString(5, cliente.getCpf());
			stmt.setString(6, cliente.getTelefone());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				cliente.setIdCliente(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return cliente;
	}

	// EDITAR CADASTRO DO CLIENTE
	public Cliente editar(Cliente cliente) {
		String sql = "UPDATE cliente SET nome=?, sobrenome=?, login=?, senha=?, cpf=?, telefone=? WHERE id_cliente=?";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSobrenome());
			stmt.setString(3, cliente.getLogin());
			stmt.setString(4, cliente.getSenha());
			stmt.setString(5, cliente.getCpf());
			stmt.setString(6, cliente.getTelefone());
			stmt.setLong(7, cliente.getIdCliente());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return cliente;
	}

	// EXCLUIR CADASTRO POR ID
	public void deletarPorId(long id) {
		String sql = "DELETE FROM cliente WHERE id_cliente=?";
		conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
	}

	// BUSCAR CADASTRO POR ID
	public Cliente buscarPorId(long id) {
		Cliente cliente = null;
		String sql = "SELECT * FROM cliente WHERE id_cliente=?";
		this.conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			// CONVERTER RESULTSET EM UM OBJETO DO TIPO CLIENTE
			if (rs.next()) { // VERIFICA SE A PR�XIMA LINHA EXISTE
				cliente = new Cliente();
				cliente.setIdCliente(rs.getLong("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setLogin(rs.getString("login"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return cliente;
	}

	// BUSCAR TODOS OS CLIENTES CADASTRADOS
	public List<Cliente> buscarTodos() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		String sql = "SELECT * FROM cliente";
		this.conexao.abrirConexao();
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			// VERIFICAR SE EXISTE PR�XIMA LINHA E CONVERTER EM UM OBJETO
			// CLIENTE, EXECUTAR O ALGORITMO NOVAMENTE
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getLong("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setLogin(rs.getString("login"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("telefone"));
				listaClientes.add(cliente);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}

		return listaClientes;
	}
}
