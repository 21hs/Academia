package InterfacesdeServiço;

import java.util.List;
import Entidades.Sala;

public interface ISalaService {
    void cadastrarSala(Sala sala);
    Sala buscarSala(int numero);
    void atualizarSala(Sala sala);
    void atualizarSala(int numero, int novaCapacidade);
    void removerSala(int numero);
    List<Sala> listarSalas();
}