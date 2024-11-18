package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Entidades.Atividade;
import InterfaceRepositorio.IAtividadeRepository;

public class AtividadeRepository implements IAtividadeRepository {
    private List<Atividade> atividades = new ArrayList<>();

    @Override
    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    @Override
    public Atividade buscarAtividade(String nome) {
        return atividades.stream().filter(a -> a.getNome().equals(nome)).findFirst().orElse(null);
    }

    @Override
    public void atualizarAtividade(Atividade atividade) {
        int index = -1;
        for (int i = 0; i < atividades.size(); i++) {
            if (atividades.get(i).getNome().equals(atividade.getNome())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            atividades.set(index, atividade);
        }
    }

    @Override
    public void removerAtividade(String nome) {
        atividades.removeIf(a -> a.getNome().equals(nome));
    }

    @Override
    public List<Atividade> listarTodos() {
        return new ArrayList<>(atividades);
    }
}