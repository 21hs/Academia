package InterfaceRepositorio;

import java.util.List;

import Entidades.Sala;

public interface ISalaRepository {
    void adicionarSala(Sala sala);
    Sala buscarSala(int numero);
    void atualizarSala(Sala sala);
    void removerSala(int numero);
    List<Sala> listarTodos();
}