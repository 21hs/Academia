package Repositorio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Entidades.Membro;
import InterfaceRepositorio.IMembroRepository;

public class MembroRepository implements IMembroRepository {
    private List<Membro> membros = new ArrayList<>();
    private static Queue<Membro> filaMembros = new LinkedList<>();
    private static int contadorId = 1;

    @Override
    public void adicionarMembro(Membro membro) {
        membro.setId(contadorId++); 
        membros.add(membro);
        adicionarMembroNaFila(membro); // Adiciona à fila ao cadastrar
    }

    @Override
    public Membro buscarMembro(int id) {
        for (Membro membro : membros) {
            if (membro.getId() == id) {
                return membro;
            }
        }
        return null;
    }

    @Override
    public void atualizarMembro(Membro membro) {
        for (int i = 0; i < membros.size(); i++) {
            if (membros.get(i).getId() == membro.getId()) {
                membros.set(i, membro);
                return;
            }
        }
    }

    @Override
    public void removerMembro(int id) {
        membros.removeIf(membro -> membro.getId() == id);
    }

    @Override
    public List<Membro> listarTodos() {
        return new ArrayList<>(membros);
    }

    // Métodos para gerenciar a fila de membros
    public static void adicionarMembroNaFila(Membro membro) {
        if (!filaMembros.contains(membro)) { // Verifica se o membro já está na fila
            filaMembros.add(membro);
            System.out.println("Membro adicionado à fila: " + membro.getNome());
        } else {
            System.out.println("Membro já está na fila: " + membro.getNome());
        }
    }

    public static Membro removerMembroDaFila() {
        Membro membroRemovido = filaMembros.poll();
        if (membroRemovido != null) {
            System.out.println("Membro removido da fila: " + membroRemovido.getNome());
        } else {
            System.out.println("A fila está vazia.");
        }
        return membroRemovido;
    }

    public static boolean isFilaVazia() {
        return filaMembros.isEmpty();
    }
}