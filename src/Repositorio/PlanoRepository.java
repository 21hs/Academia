package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Entidades.Plano;
import InterfaceRepositorio.IPlanoRepository;

public class PlanoRepository implements IPlanoRepository {
    private List<Plano> planos = new ArrayList<>();

    @Override
    public void adicionarPlano(Plano plano) {
        planos.add(plano);
    }

    @Override
    public Plano buscarPlano(String nome) {
        for (Plano plano : planos) {
            if (plano.getNome().equalsIgnoreCase(nome)) {
                return plano;
            }
        }
        return null;
    }

    @Override
    public void atualizarPlano(Plano plano) {
        for (int i = 0; i < planos.size(); i++) {
            if (planos.get(i).getNome().equalsIgnoreCase(plano.getNome())) {
                planos.set(i, plano);
                return;
            }
        }
    }

    @Override
    public void removerPlano(String nome) {
        planos.removeIf(plano -> plano.getNome().equalsIgnoreCase(nome));
    }

    @Override
    public List<Plano> listarTodos() {
        return new ArrayList<>(planos);
    }
}