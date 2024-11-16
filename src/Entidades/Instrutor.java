package Entidades;

public class Instrutor extends Pessoa {
    private String especialidade;

    // Construtor que recebe nome, cpf e especialidade
    public Instrutor(String nome, String cpf, String especialidade) {
        super(nome, cpf);  // Chama o construtor da classe Pessoa
        this.especialidade = especialidade;
    }

    // Construtor padrão (sem parâmetros)
    public Instrutor() {
        super();  // Chama o construtor da classe Pessoa, que pode ser um construtor sem parâmetros
        this.especialidade = "";  // Inicializa a especialidade com uma string vazia ou valor default
    }

    // Getter e Setter para especialidade
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    // Método toString para exibir as informações do instrutor
    @Override
    public String toString() {
        return "ID: " + getId() + ", Nome: " + getNome() + ", CPF: " + getCpf() + ", Especialidade: " + especialidade;
    }
}