package Serviços;

import DAO.FichaTreinoDAO;
import Entidades.FichaTreino;

public class FichaTreinoService {
    private FichaTreinoDAO fichaTreinoDAO;

    public FichaTreinoService() {
        this.fichaTreinoDAO = new FichaTreinoDAO();
    }

    public void cadastrarFichaTreino(FichaTreino fichaTreino) {
        if (fichaTreino != null && fichaTreino.getMembro() != null && fichaTreino.getInstrutor() != null) {
            fichaTreinoDAO.cadastrarFichaTreino(fichaTreino);
        } else {
            System.out.println("Dados inválidos para cadastrar a ficha.");
        }
    }
}