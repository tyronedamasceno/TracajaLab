package com.example.tyrone.tracajalab.Domain;

public class Exame {

    private String nome;
    private String orientacao;
    private String jejum;

    public Exame(String nome, String orientacao, String jejum) {
        this.nome = nome;
        this.orientacao = orientacao;
        this.jejum = jejum;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(String orientacao) {
        this.orientacao = orientacao;
    }

    public String getJejum() {
        return jejum;
    }

    public void setJejum(String jejum) {
        this.jejum = jejum;
    }
}
