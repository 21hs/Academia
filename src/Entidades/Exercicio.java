package Entidades;

public class Exercicio {
    private String nome;

    public Exercicio(int idExercicio, String nome, String descricaoExercicio) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}