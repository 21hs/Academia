package Entidades;

public class Atividade {
    private int id;
    private String nome;
    private String descricao;
    private String instrutor;

    // Construtor vazio (padrão)
    public Atividade() {
    }

    // Construtor com todos os campos
    public Atividade(int id, String nome, String descricao, String instrutor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.instrutor = instrutor;
    }

    // Construtor sem o ID, útil para casos onde o ID é gerado automaticamente
    public Atividade(String nome, String descricao, String instrutor) {
        this.nome = nome;
        this.descricao = descricao;
        this.instrutor = instrutor;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    // Método toString para facilitar a exibição de informações
    @Override
    public String toString() {
        return "Atividade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", instrutor='" + instrutor + '\'' +
                '}';
    }
}