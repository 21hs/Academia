package Serviços;

import DAO.AtividadeDAO;
import Entidades.Atividade;
import java.util.List;

public class AtividadeService {

    private AtividadeDAO atividadeDAO;

    public AtividadeService(AtividadeDAO atividadeDAO2) {
        this.atividadeDAO = new AtividadeDAO();
    }

    // Método para listar todas as atividades
    public List<Atividade> listarAtividades() {
        return atividadeDAO.getAtividade();
    }

    // Método para atualizar uma atividade
    public void atualizarAtividade(Atividade atividade) {
        atividadeDAO.update(atividade);
    }

    // Método para buscar uma atividade pelo nome
    public Atividade buscarAtividade(String nome) {
        return atividadeDAO.buscarAtividadePorNome(nome);
    }

    // Método para remover uma atividade pelo ID
    public void removerAtividade(int id) {
        atividadeDAO.deleteByID(id);
    }
}