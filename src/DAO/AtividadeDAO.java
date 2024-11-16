package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DatabaseConnection;
import Entidades.Atividade;

public class AtividadeDAO {

    public void cadastrarAtividade(Atividade atividade) {
        String sql = "INSERT INTO ATIVIDADE (nome, descricao, instrutor) VALUES (?, ?, ?)";

        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = DatabaseConnection.getConexao();
            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.setString(1, atividade.getNome());
                ps.setString(2, atividade.getDescricao());
                ps.setString(3, atividade.getInstrutor());

                ps.executeUpdate();
            } else {
                System.out.println("Falha ao obter conexão.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(Atividade atividade) {
        String sql = "UPDATE atividade SET nome = ?, descricao = ?, instrutor = ? WHERE atividade_id = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, atividade.getNome());
            ps.setString(2, atividade.getDescricao());
            ps.setString(3, atividade.getInstrutor());
            ps.setInt(4, atividade.getId());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteByID(int id) {
        String sql = "DELETE FROM atividade WHERE atividade_id = ?";

        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = DatabaseConnection.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Atividade> getAtividade() {
        String sql = "SELECT * FROM ATIVIDADE";

        List<Atividade> atividades = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rset = null;

        try {
            conn = DatabaseConnection.getConexao();
            ps = conn.prepareStatement(sql);

            rset = ps.executeQuery();

            while (rset.next()) {
                Atividade atividade = new Atividade();
                atividade.setId(rset.getInt("atividade_id"));
                atividade.setNome(rset.getString("nome"));
                atividade.setDescricao(rset.getString("descricao"));
                atividade.setInstrutor(rset.getString("instrutor"));

                atividades.add(atividade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return atividades;
    }

    // Método para buscar atividade pelo nome
    public Atividade buscarAtividadePorNome(String nome) {
        String sql = "SELECT * FROM ATIVIDADE WHERE nome = ?";

        Atividade atividade = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rset = null;

        try {
            conn = DatabaseConnection.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            rset = ps.executeQuery();

            if (rset.next()) {
                atividade = new Atividade();
                atividade.setId(rset.getInt("atividade_id"));
                atividade.setNome(rset.getString("nome"));
                atividade.setDescricao(rset.getString("descricao"));
                atividade.setInstrutor(rset.getString("instrutor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return atividade;
    }
}