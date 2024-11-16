package Entidades;

public class Membro extends Pessoa {
    private Plano plano;

    // Construtor com todos os parâmetros
    public Membro(int id, String nome, String cpf, Plano plano) {
        super(id, nome, cpf);  // Chama o construtor da classe Pessoa
        this.plano = plano;
    }

    // Construtor adicional para cadastrar membro sem plano, será útil para gerenciar novos membros
    public Membro(String nome, String cpf, Plano plano) {
        super(nome, cpf);  // Chama o construtor da classe Pessoa
        this.plano = plano;
    }

    // Getter e Setter para o Plano
    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    // Método para associar um plano a um membro, fornecendo o nome do plano
    public void setPlano(String nomePlano) {
        this.plano = buscarPlanoPorNome(nomePlano);
    }

    // Método auxiliar para buscar o plano pelo nome
    private Plano buscarPlanoPorNome(String nome) {
        // Aqui você pode implementar a lógica para buscar um plano no banco de dados
        // ou retornar um plano fictício para fins de testes.
        // Exemplo simplificado:
        if ("Plano Básico".equalsIgnoreCase(nome)) {
            return new Plano("Plano Básico", 100.00);
        } else if ("Plano Avançado".equalsIgnoreCase(nome)) {
            return new Plano("Plano Avançado", 150.00);
        }
        return null; // Caso o plano não seja encontrado
    }
}