package Entidades;

public class Sala {
    private int salaId;  // ID da sala
    private String nome;  // Nome da sala
    private int capacidade;  // Capacidade da sala

    // Construtor com nome e capacidade
    public Sala(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    // Construtor sem parâmetros
    public Sala() {
        // Este construtor permite criar uma sala sem passar parâmetros inicialmente
    }

    // Getter para salaId
    public int getSalaId() {
        return salaId;
    }

    // Setter para salaId
    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }

    // Getter para nome
    public String getNome() {
        return nome;
    }

    // Setter para nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para capacidade
    public int getCapacidade() {
        return capacidade;
    }

    // Setter para capacidade
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}