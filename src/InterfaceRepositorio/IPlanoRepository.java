package InterfaceRepositorio;

import java.util.List;

import Entidades.Plano;

public interface IPlanoRepository {
    void adicionarPlano(Plano plano);
    Plano buscarPlano(String nome);
    void atualizarPlano(Plano plano);
    void removerPlano(String nome);
    List<Plano> listarTodos();
}