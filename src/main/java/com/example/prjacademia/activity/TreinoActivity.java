package com.example.prjacademia.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prjacademia.R;
import com.example.prjacademia.adapter.ExercicioAdapter;
import com.example.prjacademia.dao.ExercicioDAO;
import com.example.prjacademia.model.Exercicio;

public class TreinoActivity extends AppCompatActivity {

    private ExercicioDAO exercicioDAO;
    private ExercicioAdapter exercicioAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Treino de hoje");
        setContentView(R.layout.treino_activity);
        exercicioDAO = new ExercicioDAO();
        exercicioAdapter = new ExercicioAdapter(this);
        inicializaExerciciosNaListView();
        ListView lvExercicios = findViewById(R.id.treino_activity_list_view);
        lvExercicios.setAdapter(exercicioAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        exercicioAdapter.atualizaDados(exercicioDAO.findAll());
    }

    private void inicializaExerciciosNaListView() {
        Exercicio ex = new Exercicio();
        ex.setCarga(30.0F);
        ex.setRepeticoes(12);
        ex.setSeries(3);
        ex.setNome("rosca direta");
        exercicioDAO.adiciona(ex);
        ex = new Exercicio();
        ex.setCarga(60.0F);
        ex.setSeries(3);
        ex.setRepeticoes(12);
        ex.setNome("rosca alternada");
        exercicioDAO.adiciona(ex);
    }
}
