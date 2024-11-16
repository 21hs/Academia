package DAO;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;  // Importando List e ArrayList
import Entidades.Plano;
import DatabaseConnection.DatabaseConnection;

public class PlanoDAO {

    // Método para adicionar um plano no banco
    public void adicionarPlano(Plano plano) {
        String sql = "INSERT INTO plano (nome, valor) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, plano.getNome());
            ps.setDouble(2, plano.getValor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar planos do banco
    public List<Plano> listarPlanos() {
        List<Plano> planos = new ArrayList<>();
        String sql = "SELECT id, nome, valor FROM plano";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rset = ps.executeQuery()) {

            while (rset.next()) {
                Plano plano = new Plano(rset.getString("nome"), rset.getDouble("valor"));
                plano.setId(rset.getInt("id"));
                planos.add(plano);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planos;
    }

    // Método para buscar um plano pelo ID
    public Plano buscarPlanoPorId(int id) {
        String sql = "SELECT id, nome, valor FROM plano WHERE id = ?";
        Plano plano = null;

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id); // Definir o ID do plano no PreparedStatement
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                plano = new Plano(rs.getString("nome"), rs.getDouble("valor"));
                plano.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plano;
    }
}