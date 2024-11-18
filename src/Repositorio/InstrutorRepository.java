package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Entidades.Instrutor;
import InterfaceRepositorio.IInstrutorRepository;

public class InstrutorRepository implements IInstrutorRepository {
    private List<Instrutor> instrutores = new ArrayList<>();

    @Override
    public void adicionarInstrutor(Instrutor instrutor) {
        instrutores.add(instrutor);
    }

    @Override
    public Instrutor buscarInstrutor(String cpf) {
        return instrutores.stream().filter(i -> i.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    @Override
    public void atualizarInstrutor(Instrutor instrutor) {
        int index = -1;
        for (int i = 0; i < instrutores.size(); i++) {
            if (instrutores.get(i).getCpf().equals(instrutor.getCpf())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            instrutores.set(index, instrutor);
        }
    }

    @Override
    public void removerInstrutor(String cpf) {
        instrutores.removeIf(i -> i.getCpf().equals(cpf));
    }

    @Override
    public List<Instrutor> listarTodos() {
        return new ArrayList<>(instrutores);
    }
}