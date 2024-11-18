package InterfaceRepositorio;

import java.util.List;

import Entidades.Instrutor;

public interface IInstrutorRepository {
    void adicionarInstrutor(Instrutor instrutor);
    Instrutor buscarInstrutor(String cpf);
    void atualizarInstrutor(Instrutor instrutor);
    void removerInstrutor(String cpf);
    List<Instrutor> listarTodos();
}