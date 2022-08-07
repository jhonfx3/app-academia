package com.example.prjacademia.model;

import java.util.List;

public class Treino {
    private List<Exercicio> exercicios;
    private String nome;


    public Treino() {

    }

    public Treino(String nome) {
        this.nome = nome;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }
}
