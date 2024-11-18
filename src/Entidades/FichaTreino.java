package Entidades;

import java.util.ArrayList;
import java.util.List;

public class FichaTreino {
    private int fichaid;
    private Membro membro;
    private Instrutor instrutor;
    private List<Atividade> atividades;
    private String descricao;
    private String dataInicio;
    private String dataFim;

    // Construtor com atividades
    public FichaTreino(Membro membro, Instrutor instrutor, List<Atividade> atividades, String dataInicio, String dataFim) {
        this.membro = membro;
        this.instrutor = instrutor;
        this.atividades = atividades != null ? atividades : new ArrayList<>();  // Evita NPE se atividades for null
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Construtor sem atividades (apenas com os dados básicos)
    public FichaTreino(Membro membro, Instrutor instrutor, String descricao, String dataInicio, String dataFim) {
        this(membro, instrutor, new ArrayList<>(), dataInicio, dataFim);  // Inicializa atividades como lista vazia
        this.descricao = descricao;
    }

    // Getters e Setters
    public int getFichaid() {
        return fichaid;
    }

    public void setFichaid(int fichaid) {
        this.fichaid = fichaid;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}