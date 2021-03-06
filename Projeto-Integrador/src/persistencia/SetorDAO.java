package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Setor;

public class SetorDAO {

    Conexao conexao;

    public SetorDAO() {
        this.conexao = new Conexao("localhost", "bd_hotel", "root", "");
    }

    public Setor salvar(Setor setor) {
        String sql = "INSERT INTO setor (cod_setor, setor, salario) VALUES (null,?,?)";
        conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, setor.getNomeSetor());
            stmt.setDouble(2, setor.getSalario());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                setor.setCodSetor(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return setor;
    }

    public void deletar(long codSetor) {
        String sql = "DELETE FROM setor WHERE cod_setor = ?";
        conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, codSetor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public Setor editar(Setor setor) {
        String sql = "UPDATE setor SET setor=?, salario=? WHERE cod_setor=?";
        conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setString(1, setor.getNomeSetor());
            stmt.setDouble(2, setor.getSalario());
            stmt.setLong(3, setor.getCodSetor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return setor;
    }

    public List<Setor> pesquisar() {
        List<Setor> listaSetor = new ArrayList<Setor>();
        String sql = "SELECT * FROM setor";
        conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Setor setor = new Setor();
                setor.setCodSetor(rs.getLong("cod_setor"));
                setor.setNomeSetor(rs.getString("setor"));
                setor.setSalario(rs.getDouble("salario"));
                listaSetor.add(setor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return listaSetor;
    }

    public Setor pesquisarPorId(long id) {
        Setor setor = null;
        
        String sql = "SELECT * FROM setor WHERE cod_setor=?";
        conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                setor = new Setor();
                setor.setCodSetor(rs.getLong("cod_setor"));
                setor.setNomeSetor(rs.getString("setor"));
                setor.setSalario(rs.getDouble("salario"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return setor;
    }

}
