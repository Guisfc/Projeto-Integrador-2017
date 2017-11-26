package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Categoria;

public class CategoriaDAO {

    Conexao conexao;

    public CategoriaDAO() {
        this.conexao = new Conexao("localhost", "bd_hotel", "root", "");
    }

    // SALVAR CATEGORIA
    public Categoria salvar(Categoria categoria) {
        String sql = "INSERT INTO categoria VALUES(null, ?, ?, ?)";
        this.conexao.abrirConexao();
        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, categoria.getTipo());
            stmt.setString(2, categoria.getDescricao());
            stmt.setDouble(3, categoria.getValorDiaria());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                categoria.setIdCategoria(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return categoria;
    }

    // EDITAR CATEGORIA
    public Categoria editar(Categoria categoria) {
        String sql = "UPDATE categoria SET tipo=?, descricao=?, valor_diaria=? WHERE id_categoria=?";
        this.conexao.abrirConexao();
        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
            stmt.setString(1, categoria.getTipo());
            stmt.setString(2, categoria.getDescricao());
            stmt.setDouble(3, categoria.getValorDiaria());
            stmt.setInt(4, categoria.getIdCategoria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return categoria;
    }

    // DELETAR CATEGORIA POR ID
    public void deletarPorId(int id) {
        String sql = "DELETE FROM categoria WHERE id_categoria=?";
        this.conexao.abrirConexao();
        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    // BUSCAR CATEGORIA POR ID
    public Categoria buscarPorId(int id) {
        Categoria categoria = null;
        String sql = "SELECT * FROM categoria WHERE id_categoria=?";
        this.conexao.abrirConexao();
        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setTipo(rs.getString("tipo"));
                categoria.setDescricao(rs.getString("descricao"));
                categoria.setValorDiaria(rs.getDouble("valor_diaria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }

        return categoria;
    }

    // BUSCAR TODAS AS CATEGORIAS
    public List<Categoria> buscarTodos() {
        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        String sql = "SELECT * FROM categoria";
        this.conexao.abrirConexao();
        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setTipo(rs.getString("tipo"));
                categoria.setDescricao(rs.getString("descricao"));
                categoria.setValorDiaria(rs.getDouble("valor_diaria"));
                listaCategorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaCategorias;
    }
}
