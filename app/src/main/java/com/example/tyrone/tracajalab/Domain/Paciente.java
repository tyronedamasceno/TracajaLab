package com.example.tyrone.tracajalab.Domain;

import java.util.HashMap;

public class Paciente {

    private String email;
    private HashMap<String, Exame> exames;

    public Paciente(String email) {
        this.email = email;

        if (exames == null) {
            exames = new HashMap<>();
        }
    }

    public Paciente(String email, HashMap<String, Exame> exames) {
        this.email = email;
        this.exames = exames;
    }
}
