package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DatabaseConnection.DatabaseConnection;
import Entidades.Instrutor;
import Entidades.Membro;
import Entidades.Pessoa;
import Entidades.Plano;

public class PessoaDAO {

    public void cadastrarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, cpf) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCpf());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pessoa.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome = ?, cpf = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCpf());
            ps.setInt(3, pessoa.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM pessoa WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT id, nome, cpf, tipo_pessoa, plano, valor, especialidade FROM pessoa";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rset = ps.executeQuery()) {

            while (rset.next()) {
                Pessoa pessoa = null;
                int tipoPessoa = rset.getInt("tipo_pessoa");

                if (tipoPessoa == 1) {  // Tipo 1: Membro
                    Plano plano = new Plano(rset.getString("plano"), rset.getDouble("valor"));
                    pessoa = new Membro(rset.getInt("id"), rset.getString("nome"), rset.getString("cpf"), plano);
                } else if (tipoPessoa == 2) {  // Tipo 2: Instrutor
                    pessoa = new Instrutor(rset.getString("nome"), rset.getString("cpf"), rset.getString("especialidade"));
                }

                if (pessoa != null) {
                    pessoa.setId(rset.getInt("id"));
                    pessoa.setNome(rset.getString("nome"));
                    pessoa.setCpf(rset.getString("cpf"));
                    pessoas.add(pessoa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas;
    }
}