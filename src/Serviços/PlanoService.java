package Serviços;

import java.util.List;
import Entidades.Plano;
import InterfacesdeServiço.IPlanoService;
import DAO.PlanoDAO;

public class PlanoService implements IPlanoService {
    private PlanoDAO planoDAO;

    // Construtor da classe, que recebe o PlanoDAO como dependência
    public PlanoService(PlanoDAO planoDAO) {
        this.planoDAO = planoDAO;
    }

    // Método para cadastrar um novo plano
    @Override
    public void cadastrarPlano(Plano plano) {
        planoDAO.adicionarPlano(plano);  // Chama o DAO para adicionar o plano no banco
    }

    // Método para buscar um plano pelo nome
    @Override
    public Plano buscarPlano(String nome) {
        return planoDAO.buscarPlano(nome);  // Chama o DAO para buscar o plano pelo nome
    }

    // Método para atualizar um plano
    @Override
    public void atualizarPlano(Plano plano) {
        planoDAO.atualizarPlano(plano);  // Chama o DAO para atualizar o plano no banco
    }

    // Método para remover um plano pelo nome
    @Override
    public void removerPlano(String nome) {
        planoDAO.removerPlano(nome);  // Chama o DAO para remover o plano pelo nome
    }

    // Método para listar todos os planos
    @Override
    public List<Plano> listarPlanos() {
        return planoDAO.listarTodos();  // Chama o DAO para listar todos os planos
    }
}