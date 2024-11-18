package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DatabaseConnection;
import Entidades.FichaTreino;
import Entidades.Instrutor;
import Entidades.Membro;

public class FichaTreinoDAO {

    // Método para cadastrar uma ficha de treino
    public void cadastrarFichaTreino(FichaTreino ficha) {
        if (membroValido(ficha.getMembro().getId()) && instrutorValido(ficha.getInstrutor().getId())) {
            String sql = "INSERT INTO ficha_treino (membro_id, instrutor_id, descricao, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?)";

            try (Connection conn = DatabaseConnection.getConexao();
                 PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1, ficha.getMembro().getId());
                ps.setInt(2, ficha.getInstrutor().getId());
                ps.setString(3, ficha.getDescricao());
                ps.setString(4, ficha.getDataInicio());
                ps.setString(5, ficha.getDataFim());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    ficha.setFichaid(rs.getInt(1)); // Define o ID gerado
                }
                System.out.println("Ficha de treino cadastrada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao cadastrar ficha de treino: " + e.getMessage());
            }
        } else {
            System.out.println("Membro ou Instrutor inválido. Não é possível cadastrar a ficha.");
        }
    }

    // Método para verificar se um membro é válido
    private boolean membroValido(int membroId) {
        String sql = "SELECT id FROM membro WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, membroId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Retorna true se o membro existir
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar membro: " + e.getMessage());
            return false;
        }
    }

    // Método para verificar se um instrutor é válido
    private boolean instrutorValido(int instrutorId) {
        String sql = "SELECT id FROM instrutor WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, instrutorId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Retorna true se o instrutor existir
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar instrutor: " + e.getMessage());
            return false;
        }
    }

    // Buscar uma ficha de treino por ID
    public FichaTreino buscarFichaTreinoPorId(int id) {
        String sql = "SELECT * FROM ficha_treino WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Criar objetos Membro e Instrutor com base no banco
                Membro membro = buscarMembroPorId(rs.getInt("membro_id"));
                Instrutor instrutor = buscarInstrutorPorId(rs.getInt("instrutor_id"));
                String descricao = rs.getString("descricao");
                String dataInicio = rs.getString("data_inicio");
                String dataFim = rs.getString("data_fim");
                FichaTreino fichaTreino = new FichaTreino(membro, instrutor, descricao, dataInicio, dataFim);
                fichaTreino.setFichaid(rs.getInt("id"));
                return fichaTreino;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar ficha de treino: " + e.getMessage());
        }
        return null;
    }

    // Buscar Membro por ID
    private Membro buscarMembroPorId(Connection conn, int membroId) {
        String sql = "SELECT * FROM membro WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, membroId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Membro(rs.getInt("id"), rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar membro: " + e.getMessage());
        }
        return null;
    }

    // Buscar Instrutor por ID
    private Instrutor buscarInstrutorPorId(Connection conn, int instrutorId) {
        String sql = "SELECT * FROM instrutor WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, instrutorId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Instrutor(rs.getInt("id"), rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar instrutor: " + e.getMessage());
        }
        return null;
    }

    // Atualizar ficha de treino
    public void atualizarFichaTreino(FichaTreino fichaTreino) {
        if (fichaTreino != null) {
            String sql = "UPDATE ficha_treino SET membro_id = ?, instrutor_id = ?, descricao = ?, data_inicio = ?, data_fim = ? WHERE id = ?";
            try (Connection conn = DatabaseConnection.getConexao();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, fichaTreino.getMembro().getId());
                ps.setInt(2, fichaTreino.getInstrutor().getId());
                ps.setString(3, fichaTreino.getDescricao());
                ps.setString(4, fichaTreino.getDataInicio());
                ps.setString(5, fichaTreino.getDataFim());
                ps.setInt(6, fichaTreino.getFichaid());

                int linhasAfetadas = ps.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Ficha de treino atualizada com sucesso!");
                } else {
                    System.out.println("Nenhuma ficha de treino encontrada para atualização.");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar ficha de treino: " + e.getMessage());
            }
        }
    }

    // Método para excluir ficha de treino
    public void excluirFichaTreino(int id) {
        String sql = "DELETE FROM ficha_treino WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Ficha de treino excluída com sucesso!");
            } else {
                System.out.println("Ficha de treino não encontrada para exclusão.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir ficha de treino: " + e.getMessage());
        }
    }
    
    // Listar todas as fichas de treino
    public List<FichaTreino> listarFichasTreino() {
        List<FichaTreino> fichasTreino = new ArrayList<>();
        String sql = "SELECT * FROM ficha_treino";
        
        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Lê todos os resultados dentro do ResultSet
            while (rs.next()) {
                int membroId = rs.getInt("membro_id");
                int instrutorId = rs.getInt("instrutor_id");
                String descricao = rs.getString("descricao");
                String dataInicio = rs.getString("data_inicio");
                String dataFim = rs.getString("data_fim");

                // Criando os objetos Membro e Instrutor fora do loop ResultSet
                Membro membro = buscarMembroPorId(conn, membroId);
                Instrutor instrutor = buscarInstrutorPorId(conn, instrutorId);

                // Se Membro e Instrutor foram encontrados, criamos a ficha de treino
                if (membro != null && instrutor != null) {
                    FichaTreino fichaTreino = new FichaTreino(membro, instrutor, descricao, dataInicio, dataFim);
                    fichaTreino.setFichaid(rs.getInt("id"));
                    fichasTreino.add(fichaTreino);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar fichas de treino: " + e.getMessage());
            e.printStackTrace();
        }

        // Verifica se a lista de fichas foi preenchida
        if (fichasTreino.isEmpty()) {
            System.out.println("Nenhuma ficha de treino cadastrada.");
        }

        return fichasTreino;
    }
}