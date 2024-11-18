package Entidades;

public class Plano {
    private int id;
    private String nome;
    private double valor;

    // Construtor com nome e valor
    public Plano(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    // Getter e Setter para o nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para o valor
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // Getter e Setter para o id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}