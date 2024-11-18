package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Entidades.Sala;
import InterfaceRepositorio.ISalaRepository;

public class SalaRepository implements ISalaRepository {
    private List<Sala> salas = new ArrayList<>();

    @Override
    public void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    @Override
    public Sala buscarSala(int numero) {
        return salas.stream().filter(s -> s.getNumero() == numero).findFirst().orElse(null);
    }

    @Override
    public void atualizarSala(Sala sala) {
        int index = -1;
        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).getNumero() == sala.getNumero()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            salas.set(index, sala);
        }
    }

    @Override
    public void removerSala(int numero) {
        salas.removeIf(s -> s.getNumero() == numero);
    }

    @Override
    public List<Sala> listarTodos() {
        return new ArrayList<>(salas);
    }
}