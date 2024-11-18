package InterfacesdeServiço;

import java.util.List;
import Entidades.Plano;

public interface IPlanoService {
    void cadastrarPlano(Plano plano);  // Método para cadastrar plano
    Plano buscarPlano(String nome);    // Método para buscar plano pelo nome
    void atualizarPlano(Plano plano);  // Método para atualizar plano
    void removerPlano(String nome);    // Método para remover plano
    List<Plano> listarPlanos();        // Método para listar todos os planos
}