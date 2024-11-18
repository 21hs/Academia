package InterfacesdeServiço;

import java.util.List;

import Entidades.Membro;

public interface IMembroService {
    void cadastrarMembro(Membro membro);
    Membro buscarMembro(int id);
    void atualizarMembro(Membro membro);
    void removerMembro(int id);
    List<Membro> listarMembros();
	void cadastrarMembro1(Membro membro);
	void atualizarMembro1(Membro membro);
}