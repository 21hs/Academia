package InterfaceRepositorio;

import java.util.List;
import Entidades.Membro;

public interface IMembroRepository {
    void adicionarMembro(Membro membro);
    Membro buscarMembro(int id);
    void atualizarMembro(Membro membro);
    void removerMembro(int id);
    List<Membro> listarTodos();
}