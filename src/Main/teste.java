package Main;

import java.util.List;
import java.util.Scanner;

import DAO.AtividadeDAO;
import DAO.PlanoDAO;
import Entidades.Atividade;
import Entidades.Plano;

public class teste {

    public static void main(String[] args) throws Exception {
    	
    	PlanoDAO planoDAO = new PlanoDAO();
    	Plano plano = planoDAO.buscarPlanoPorId(2);  // Testando a busca por ID
    	if (plano != null) {
    	    System.out.println("Plano encontrado: " + plano.getNome());
    	} else {
    	    System.out.println("Plano não encontrado.");
    	}
    	
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome da atividade
        System.out.print("Digite o nome da atividade: ");
        String nome = scanner.nextLine();
        
        // Solicita a descrição da atividade
        System.out.print("Digite a descrição da atividade: ");
        String descricao = scanner.nextLine();
        
        // Solicita o nome do instrutor
        System.out.print("Digite o nome do instrutor: ");
        String instrutor = scanner.nextLine();
        
        // Cria a atividade com os dados inseridos pelo usuário
        Atividade a = new Atividade();
        a.setNome(nome);
        a.setDescricao(descricao);
        a.setInstrutor(instrutor);
        
        // Salva a atividade no banco de dados
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        atividadeDAO.cadastrarAtividade(a);
        
        System.out.println("Atividade cadastrada com sucesso!");
        
        scanner.close();
        
        // Exibe as atividades cadastradas
        List<Atividade> atividades = atividadeDAO.getAtividade();
        for (Atividade atividade : atividades) {
            System.out.println("Atividade ID: " + atividade.getId());
            System.out.println("Nome: " + atividade.getNome());
            System.out.println("Descrição: " + atividade.getDescricao());
            System.out.println("Instrutor: " + atividade.getInstrutor());
            System.out.println("---------------------------");
        }
    }
}

