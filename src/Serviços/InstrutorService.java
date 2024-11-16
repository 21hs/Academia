package Serviços;

import java.util.List;
import Entidades.Instrutor;
import DAO.InstrutorDAO; // Importando a classe InstrutorDAO
import InterfacesdeServiço.IInstrutorService;

public class InstrutorService implements IInstrutorService {
    private InstrutorDAO instrutorDAO; // Usando InstrutorDAO em vez de IInstrutorRepository

    // Construtor que recebe o DAO para injeção de dependência
    public InstrutorService(InstrutorDAO instrutorDAO) {
        this.instrutorDAO = instrutorDAO;
    }

    // Método para cadastrar um instrutor
    @Override
    public void cadastrarInstrutor(Instrutor instrutor) {
        instrutorDAO.adicionarInstrutor(instrutor); // Chama o método do DAO
    }

    // Método para buscar um instrutor pelo CPF
    @Override
    public Instrutor buscarInstrutor(String cpf) {
        return instrutorDAO.buscarInstrutor(cpf); // Usando o DAO para buscar no banco de dados
    }

    // Método para atualizar um instrutor
    @Override
    public void atualizarInstrutor(Instrutor instrutor) {
        instrutorDAO.atualizarInstrutor(instrutor); // Atualiza via DAO
    }

    // Método para remover um instrutor pelo CPF
    @Override
    public void removerInstrutor(String cpf) {
        instrutorDAO.removerInstrutor(cpf); // Remove via DAO
    }

    // Método para listar todos os instrutores
    @Override
    public List<Instrutor> listarInstrutores() {
        return instrutorDAO.listarTodos(); // Retorna lista de instrutores via DAO
    }
}