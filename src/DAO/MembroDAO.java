package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entidades.Membro;
import Entidades.Plano;
import DatabaseConnection.DatabaseConnection;

public class MembroDAO {

    // Verifica se o plano existe na tabela plano
    private boolean planoExiste(int planoId) {
        String sql = "SELECT id FROM plano WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, planoId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Retorna true se o plano existir
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar a existência do plano: " + e.getMessage());
            return false; // Retorna false em caso de erro
        }
    }

    // Método para cadastrar um membro
    public void cadastrarMembro(Membro membro) {
        if (planoExiste(membro.getPlano().getId())) {  // Verifica se o plano existe
            String sql = "INSERT INTO membro (nome, cpf, plano_id) VALUES (?, ?, ?)";

            try (Connection conn = DatabaseConnection.getConexao();
                 PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, membro.getNome());
                ps.setString(2, membro.getCpf());
                ps.setInt(3, membro.getPlano().getId());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    membro.setId(rs.getInt(1)); // Define o ID gerado no objeto Membro
                }
            } catch (SQLException e) {
                System.out.println("Erro ao cadastrar membro: " + e.getMessage());
            }
        } else {
            System.out.println("Plano não encontrado. Não é possível cadastrar o membro.");
        }
    }

    // Método para buscar membro por ID
    public Membro buscarMembroPorId(int id) {
        String sql = "SELECT m.id, m.nome, m.cpf, m.plano_id, p.nome AS plano_nome, p.valor AS plano_valor "
                   + "FROM membro m JOIN plano p ON m.plano_id = p.id WHERE m.id = ?";
        
        Membro membro = null;

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Plano plano = new Plano(rs.getString("plano_nome"), rs.getDouble("plano_valor"));
                plano.setId(rs.getInt("plano_id"));
                membro = new Membro(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), plano);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar membro por ID: " + e.getMessage());
        }

        return membro;
    }

    // Método para atualizar um membro
    public void atualizarMembro(Membro membro) {
        if (planoExiste(membro.getPlano().getId())) {  // Verifica se o plano existe
            String sql = "UPDATE membro SET plano_id = ? WHERE id = ?";

            try (Connection conn = DatabaseConnection.getConexao();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, membro.getPlano().getId());
                ps.setInt(2, membro.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar membro: " + e.getMessage());
            }
        } else {
            System.out.println("Plano não encontrado. Não é possível atualizar o membro.");
        }
    }

    // Método para excluir um membro
    public void excluirMembro(int id) {
        String sql = "DELETE FROM membro WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir membro: " + e.getMessage());
        }
    }

    // Método para listar todos os membros
    public List<Membro> listarMembros() {
        String sql = "SELECT m.id, m.nome, m.cpf, m.plano_id, p.nome AS plano_nome, p.valor AS plano_valor "
                   + "FROM membro m JOIN plano p ON m.plano_id = p.id";
        
        List<Membro> membros = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Plano plano = new Plano(rs.getString("plano_nome"), rs.getDouble("plano_valor"));
                plano.setId(rs.getInt("plano_id"));
                Membro membro = new Membro(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), plano);
                membros.add(membro);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar membros: " + e.getMessage());
        }

        return membros;
    }
}