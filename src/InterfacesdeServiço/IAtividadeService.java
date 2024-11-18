package InterfacesdeServiço;

import java.util.List;

import Entidades.Atividade;

public interface IAtividadeService {
    void cadastrarAtividade(Atividade atividade);
    Atividade buscarAtividade(String nome);
    void atualizarAtividade(Atividade atividade);
    void removerAtividade(String nome);
    List<Atividade> listarAtividades();
}