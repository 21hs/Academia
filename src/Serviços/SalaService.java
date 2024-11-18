package Serviços;

import DAO.SalaDAO;
import Entidades.Sala;
import java.util.List;

public class SalaService {

    private SalaDAO salaDAO;

    // Construtor que recebe o SalaDAO
    public SalaService(SalaDAO salaDAO) {
        if (salaDAO == null) {
            throw new IllegalArgumentException("SalaDAO não pode ser null");
        }
        this.salaDAO = salaDAO;  // A instância de SalaDAO já é passada como parâmetro
    }

    // Método para cadastrar uma nova sala
    public void cadastrarSala(Sala sala) {
        if (sala == null) {
            throw new IllegalArgumentException("A sala não pode ser nula");
        }
        salaDAO.cadastrarSala(sala);  // Chama o método de cadastrarSala do DAO
    }

    // Método para listar todas as salas
    public List<Sala> listarSalas() {
        return salaDAO.getSala();  // Chama o método getSala do DAO para listar todas as salas
    }

    // Método para atualizar os dados de uma sala
    public void atualizarSala(Sala sala) {
        if (sala == null || sala.getSalaId() <= 0) {
            throw new IllegalArgumentException("Sala ou ID inválido para atualização");
        }
        salaDAO.update(sala);  // Chama o método update do DAO
    }

    // Método para buscar uma sala pelo ID
    public Sala buscarSala(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de sala inválido");
        }
        return salaDAO.buscarSalaPorID(id);  // Chama o método buscarSalaPorID do DAO
    }

    // Método para remover uma sala pelo ID
    public void removerSala(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de sala inválido");
        }
        salaDAO.deleteByID(id);  // Chama o método deleteByID do DAO
    }
}