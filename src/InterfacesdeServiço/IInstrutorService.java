package InterfacesdeServiço;

import java.util.List;
import Entidades.Instrutor;

public interface IInstrutorService {
    void cadastrarInstrutor(Instrutor instrutor);
    Instrutor buscarInstrutor(String cpf);
    void atualizarInstrutor(Instrutor instrutor);
    void removerInstrutor(String cpf);
    List<Instrutor> listarInstrutores();
}