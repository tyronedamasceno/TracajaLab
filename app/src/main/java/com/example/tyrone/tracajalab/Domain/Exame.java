package com.example.tyrone.tracajalab.Domain;

import java.util.Date;

public class Exame {

    private String nome;
    private String descricao;

    public Exame(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return this.nome;
    }

    /*private String id;
    private TipoExame tipo;
    private Date data;
    private boolean pronto;
    private String resultado;

    public Exame() {

    }

    public Exame(String id, TipoExame tipo, Date data, boolean pronto, String resultado) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.pronto = pronto;
        this.resultado = resultado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoExame getTipo() {
        return tipo;
    }

    public void setTipo(TipoExame tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isPronto() {
        return pronto;
    }

    public void setPronto(boolean pronto) {
        this.pronto = pronto;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }*/
}
