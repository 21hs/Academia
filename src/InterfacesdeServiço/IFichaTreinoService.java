package InterfacesdeServiço;

import java.util.List;
import Entidades.FichaTreino;

public interface IFichaTreinoService {
    void cadastrarFichaTreino(FichaTreino fichaTreino);
    FichaTreino buscarFichaTreinoPorId(int id);
    void atualizarFichaTreino(FichaTreino fichaTreino);
    void removerFichaTreino(int id);
    List<FichaTreino> listarFichasTreino();
}