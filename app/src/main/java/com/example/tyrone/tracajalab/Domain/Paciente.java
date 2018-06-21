package com.example.tyrone.tracajalab.Domain;

import java.util.HashMap;

public class Paciente {

    private String nome;
    private String login;
    private String senha;
    private HashMap<String, Exame> exames;

    public Paciente(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;

        if (exames == null) {
            exames = new HashMap<>();
        }
    }
}
