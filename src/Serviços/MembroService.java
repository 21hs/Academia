package Serviços;

import Repositorio.MembroRepository;
import Entidades.Membro;
import java.util.List;
import DAO.MembroDAO;

public class MembroService {
    private MembroDAO membroDAO;

    public MembroService(MembroDAO membroDAO) {
        this.membroDAO = membroDAO;
    }

    public void cadastrarMembro(Membro membro) {
        membroDAO.adicionarMembro(membro); // Corrigido para membroDAO
        System.out.println("Membro cadastrado e adicionado à fila!");
    }

    public Membro buscarMembro(int id) {
        return membroDAO.buscarMembro(id); // Corrigido para membroDAO
    }

    public void atualizarMembro(Membro membro) {
        membroDAO.atualizarMembro(membro); // Corrigido para membroDAO
    }

    public void removerMembro(int id) {
        membroDAO.removerMembro(id); // Corrigido para membroDAO
    }

    public List<Membro> listarMembros() {
        return membroDAO.listarTodos(); // Corrigido para membroDAO
    }
}