package Entidades;

public class Instrutor extends Pessoa {
    private String especialidade;

    // Construtor que recebe id, nome, cpf e especialidade
    public Instrutor(int id, String nome, String cpf, String especialidade) {
        super(id, nome, cpf);  // Chama o construtor da classe Pessoa
        this.especialidade = especialidade;
    }

    // Construtor adicional que aceita apenas nome, cpf e especialidade (sem o id)
    public Instrutor(String nome, String cpf, String especialidade) {
        super(0, nome, cpf);  // Chama o construtor da classe Pessoa com valores default para id
        this.especialidade = especialidade;
    }

    // Novo construtor (adicionado) que recebe apenas id e nome
    public Instrutor(int id, String nome) {
        super(id, nome, "");  // Chama o construtor da classe Pessoa com id e nome, e cpf vazio
        this.especialidade = "";  // Inicializa a especialidade com um valor default
    }

    // Construtor padrão (sem parâmetros)
    public Instrutor() {
        super(0, "", "");  // Chama o construtor da classe Pessoa com valores default
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