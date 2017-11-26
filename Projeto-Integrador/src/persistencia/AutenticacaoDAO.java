package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Autenticacao;
import pojo.Cliente;

public class AutenticacaoDAO {

	Conexao conexao;

	public AutenticacaoDAO() {
		this.conexao = new Conexao("localhost", "bd_hotel", "root", "");
	}
	
	public void autenticar(Autenticacao usuario, String tipo) {
		String sql = "SELECT * FROM " + tipo.toLowerCase();
		conexao.abrirConexao();
		Cliente cliente = null;
		try {
			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next() && usuario.getTipo() == 0) {
				Autenticacao usuarioBd = new Autenticacao();
				usuarioBd.setLogin(rs.getString("login"));
				usuarioBd.setSenha(rs.getString("senha"));
				if (usuario.getLogin().equals(usuarioBd.getLogin()) && usuario.getSenha().equals(usuarioBd.getSenha())) {
					if (tipo.equalsIgnoreCase("cliente")) {
						usuario.setId(rs.getLong("id_cliente"));
						usuario.setTipo(1);
					} else if (tipo.equalsIgnoreCase("funcionario")){
						usuario.setId(rs.getLong("id_funcionario"));
						usuario.setTipo(2);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		
	}

}
