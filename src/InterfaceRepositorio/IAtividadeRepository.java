package InterfaceRepositorio;

import java.util.List;

import Entidades.Atividade;

public interface IAtividadeRepository {
    void adicionarAtividade(Atividade atividade);
    Atividade buscarAtividade(String nome);
    void atualizarAtividade(Atividade atividade);
    void removerAtividade(String nome);
    List<Atividade> listarTodos();
}