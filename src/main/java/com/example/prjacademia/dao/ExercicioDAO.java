package com.example.prjacademia.dao;

import com.example.prjacademia.model.Exercicio;

import java.util.ArrayList;
import java.util.List;

public class ExercicioDAO {
    private static final List<Exercicio> exercicios = new ArrayList<>();
    private static int contadorDeIds = 1;


    public void adiciona(Exercicio exercicio) {
        exercicio.setId(contadorDeIds);
        exercicios.add(exercicio);
        contadorDeIds++;
    }

    public void edita(Exercicio exercicio) {
        int indice = exercicios.indexOf(exercicio);
        exercicios.set(indice, exercicio);
    }

    public Exercicio findById(int idBuscado) {
        for (Exercicio exercicio : exercicios) {
            if (exercicio.getId() == idBuscado) {
                return exercicio;
            }
        }
        return null;
    }

    private void remove(Exercicio exercicio) {
        Exercicio exercicioBuscado = findById(exercicio.getId());
        exercicios.remove(exercicioBuscado);
    }


    public Exercicio findLast() {
        if (exercicios.isEmpty()) return null;
        if (exercicios.get(exercicios.size() - 1) == null) return null;
        return exercicios.get(exercicios.size() - 1);
    }

    public ArrayList<Exercicio> findAll() {
        return new ArrayList<>(exercicios);
    }

}
