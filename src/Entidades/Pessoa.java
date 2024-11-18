package Entidades;

public abstract class Pessoa {
    protected int id;
    private String nome;
    private String cpf;

    // Construtor padrão sem parâmetros
    public Pessoa() {}

    // Construtor que aceita id, nome e cpf
    public Pessoa(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    // Construtor que aceita apenas nome e cpf (ID será gerado ou configurado posteriormente)
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}