package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Funcionario;
import pojo.Setor;

public class FuncionarioDAO {

    Conexao conexao;

    public FuncionarioDAO() {
        this.conexao = new Conexao("localhost", "bd_hotel", "root", "");
    }

    public Funcionario salvar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (id_funcionario, nome, sobrenome, login, senha, cpf, telefone, cod_setor) VALUES (null,?,?,?,?,?,?,?)";
        conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getSobrenome());
            stmt.setString(3, funcionario.getLogin());
            stmt.setString(4, funcionario.getSenha());
            stmt.setString(5, funcionario.getCpf());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setLong(7, funcionario.getSetor().getCodSetor());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                funcionario.setIdFuncionario(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return funcionario;
    }

    public void deletar(long idFuncionario) {
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
        conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, idFuncionario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public Funcionario editar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome=?, sobrenome=?, login=?, senha=?, cpf=?, telefone=?, cod_setor=? WHERE id_funcionario=?";
        conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getSobrenome());
            stmt.setString(3, funcionario.getLogin());
            stmt.setString(4, funcionario.getSenha());
            stmt.setString(5, funcionario.getCpf());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setLong(7, funcionario.getSetor().getCodSetor());
            stmt.setLong(8, funcionario.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return funcionario;
    }

    public List<Funcionario> pesquisar() {
        List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        String sql = "SELECT * FROM funcionario INNER JOIN setor ON funcionario.cod_setor=setor.cod_setor";
        conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getLong("id_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSobrenome(rs.getString("sobrenome"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));

                Setor setor = new Setor();
                setor.setCodSetor(rs.getLong("cod_setor"));
                setor.setNomeSetor(rs.getString("setor"));

                funcionario.setSetor(setor);
                listaFuncionario.add(funcionario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return listaFuncionario;
    }

    public Funcionario pesquisarPorId(long id) {
        String sql = "SELECT * FROM funcionario INNER JOIN setor ON funcionario.cod_setor=setor.cod_setor WHERE id_funcionario=?";
        conexao.abrirConexao();
        Funcionario funcionario = null;
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getLong("id_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSobrenome(rs.getString("sobrenome"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));

                Setor setor = new Setor();
                setor.setCodSetor(rs.getLong("cod_setor"));
                setor.setNomeSetor(rs.getString("setor"));

                funcionario.setSetor(setor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return funcionario;
    }

}
