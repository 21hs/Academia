package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DatabaseConnection;
import Entidades.Sala;

public class SalaDAO {

    // Método para cadastrar uma nova sala
    public void cadastrarSala(Sala sala) {
        String sql = "INSERT INTO SALA (capacidade) VALUES (?)";
        
        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, sala.getCapacidade());
			ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Você pode querer lançar uma exceção customizada
        }
    }

    // Método para atualizar uma sala
    public void update(Sala sala) {
        String sql = "UPDATE sala SET capacidade = ? WHERE sala_id = ?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (conn != null) {
                ps.setInt(1, sala.getCapacidade());
                ps.setInt(2, sala.getSalaId());  // Use getSalaId() para pegar o ID da sala
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Pode ser tratado com uma exceção customizada
        }
    }

    // Método para deletar uma sala pelo ID
    public void deleteByID(int id) {
        String sql = "DELETE FROM sala WHERE sala_id = ?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (conn != null) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todas as salas
    public List<Sala> getSala() {
        String sql = "SELECT * FROM SALA";
        List<Sala> salas = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rset = ps.executeQuery()) {
            while (rset.next()) {
                Sala sala = new Sala();
                sala.setSalaId(rset.getInt("sala_id"));
                sala.setCapacidade(rset.getInt("capacidade"));
                salas.add(sala);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar erros de maneira mais específica
        }
        return salas;
    }

    // Método para buscar sala pelo ID
    public Sala buscarSalaPorID(int id) {
        String sql = "SELECT * FROM SALA WHERE sala_id = ?";
        Sala sala = null;

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);  // Usando o ID fornecido para buscar a sala
            try (ResultSet rset = ps.executeQuery()) {
                if (rset.next()) {
                    sala = new Sala();
                    sala.setSalaId(rset.getInt("sala_id"));
                    sala.setCapacidade(rset.getInt("capacidade"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar exceções de forma mais eficaz
        }
        return sala;
    }
}