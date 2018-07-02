package com.example.tyrone.tracajalab.Domain;

public class Exame {

    private String nome;
    private String orientacao;
    private String jejum;
    private String resultado;
    private MyDate data;
    private boolean pronto;

    public Exame(String nome, String orientacao, String jejum, MyDate data, boolean pronto) {
        this.nome = nome;
        this.orientacao = orientacao;
        this.jejum = jejum;
        this.data = data;
        this.pronto = pronto;
    }

    public Exame(String nome, String orientacao, String jejum) {
        this.nome = nome;
        this.orientacao = orientacao;
        this.jejum = jejum;
    }

    public Exame (MyDate data) {
        this.data = data;
    }

    public Exame (MyDate data, String resultado) {
        this.data = data;
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
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

    public boolean isPronto() {
        return pronto;
    }

    public void setPronto(boolean pronto) {
        this.pronto = pronto;
    }

    public MyDate getData() {
        return data;
    }

    public void setData(MyDate data) {
        this.data = data;
    }
}
