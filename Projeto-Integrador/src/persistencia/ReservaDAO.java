package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Categoria;
import pojo.Cliente;

import pojo.Quarto;
import pojo.Reserva;

public class ReservaDAO {

    Conexao conexao;

    public ReservaDAO() {
        this.conexao = new Conexao("localhost", "bd_hotel", "root", "");
    }

    // SALVAR RESERVA
    public Reserva salvar(Reserva reserva) {
        String sql = "INSERT INTO reserva VALUES(null, ?, ?, ?, ?)";
        this.conexao.abrirConexao();
        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setDate(1, new java.sql.Date(reserva.getDataSqlEntrada().getTime()));
            stmt.setDate(2, new java.sql.Date(reserva.getDataSqlSaida().getTime()));
            stmt.setLong(3, reserva.getQuarto().getIdQuarto());
            stmt.setLong(4, reserva.getCliente().getIdCliente());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                reserva.setIdReserva(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return reserva;
    }

    // EDITAR RESERVA
    public Reserva editar(Reserva reserva) {
        String sql = "UPDATE reserva SET data_entrada=?, data_saida=?, id_quarto=?, id_cliente=? WHERE id_reserva=?";
        conexao.abrirConexao();
        try {
            PreparedStatement stmt = this.conexao.getConexao().prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(reserva.getDataSqlEntrada().getTime()));
            stmt.setDate(2, new java.sql.Date(reserva.getDataSqlSaida().getTime()));
            stmt.setLong(3, reserva.getQuarto().getIdQuarto());
            stmt.setLong(4, reserva.getCliente().getIdCliente());
            stmt.setLong(5, reserva.getIdReserva());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return reserva;
    }

    // EXCLUIR RESERVA POR ID
    public void deletarPorId(long id) {
        Quarto quarto = new Quarto();
        String sql = "DELETE FROM reserva WHERE id_reserva=?";
        conexao.abrirConexao();
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

    // BUSCAR RESERVA POR ID
    public Reserva buscarPorId(long id) {
        Reserva reserva = null;
        String sql = "SELECT * FROM cliente INNER JOIN reserva ON cliente.id_cliente=reserva.id_cliente WHERE id_reserva=?";
        this.conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            // CONVERTER RESULTSET EM UM OBJETO DO TIPO RESERVA
            if (rs.next()) {
                reserva = new Reserva();
                reserva.setIdReserva(rs.getLong("id_reserva"));
                reserva.setDataSqlEntrada(rs.getDate("data_entrada"));
                reserva.setDataSqlSaida(rs.getDate("data_saida"));

                Quarto quarto = new Quarto();
                quarto.setIdQuarto(rs.getLong("id_quarto"));
                quarto.setStatusDisponivel(rs.getInt("disponivel"));
                quarto.setStatusLimpeza(rs.getInt("limpo"));
                reserva.setQuarto(quarto);

                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getLong("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                cliente.setLogin(rs.getString("login"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                reserva.setCliente(cliente);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return reserva;
    }

    // BUSCAR TODAS AS RESERVAS CADASTRADAS
    public List<Reserva> buscarTodos() {
        List<Reserva> listaReservas = new ArrayList<Reserva>();
        String sql = "SELECT * FROM cliente INNER JOIN reserva ON cliente.id_cliente=reserva.id_cliente";
        this.conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            // VERIFICAR SE EXISTE PR�XIMA LINHA E CONVERTER EM UM OBJETO
            // RESERVA, EXECUTAR O ALGORITMO NOVAMENTE
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva = new Reserva();
                reserva.setIdReserva(rs.getLong("id_reserva"));
                reserva.setDataSqlEntrada(rs.getDate("data_entrada"));
                reserva.setDataSqlSaida(rs.getDate("data_saida"));

                Quarto quarto = new Quarto();
                quarto.setIdQuarto(rs.getLong("id_quarto"));
                reserva.setQuarto(quarto);

                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getLong("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                reserva.setCliente(cliente);

                listaReservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return listaReservas;
    }

    // METODO QUE PEGA O PRIMEIRO QUARTO DA LISTA DE DISPON�VEIS DE ACORDO COM A CATEGORIA ESCOLHIDA
    public Quarto sortearQuarto(int id) {
        List<Quarto> listaIds = new ArrayList<Quarto>();
        String sql = "SELECT * FROM quarto WHERE disponivel=1 AND id_categoria = ?";
        this.conexao.abrirConexao();
        Quarto quartoReservado = null;
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Quarto quarto = new Quarto();
                quarto.setIdQuarto(rs.getLong("id_quarto"));
                quarto.setStatusDisponivel(rs.getInt("disponivel"));
                quarto.setStatusLimpeza(rs.getInt("limpo"));

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                quarto.setCategoria(categoria);

                listaIds.add(quarto);
            }
            if (!listaIds.isEmpty()) {
                quartoReservado = listaIds.get(0);
                quartoReservado.setStatusDisponivel(0);
                QuartoDAO quartoDAO = new QuartoDAO();
                quartoDAO.editarDisponivel(quartoReservado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quartoReservado;
    }
    
    public Reserva checkout(Reserva reserva) {
        String sql = "SELECT * FROM reserva INNER JOIN quarto ON reserva.id_quarto=quarto.id_quarto WHERE id_reserva=?";
        this.conexao.abrirConexao();
        try {
            PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);
            stmt.setLong(1, reserva.getIdReserva());
            ResultSet rs = stmt.executeQuery();
            // CONVERTER RESULTSET EM UM OBJETO DO TIPO RESERVA
            if (rs.next()) {
                reserva.setIdReserva(rs.getLong("id_reserva"));

                Quarto quarto = new Quarto();
                quarto.setIdQuarto(rs.getLong("id_quarto"));
                reserva.setQuarto(quarto);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return reserva;
    }

}
