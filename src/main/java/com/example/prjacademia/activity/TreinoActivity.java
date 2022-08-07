package com.example.prjacademia.activity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prjacademia.R;
import com.example.prjacademia.adapter.ExercicioAdapter;
import com.example.prjacademia.dao.ExercicioDAO;
import com.example.prjacademia.model.Exercicio;
import com.example.prjacademia.model.Treino;

import java.util.ArrayList;

public class TreinoActivity extends AppCompatActivity {

    private ExercicioDAO exercicioDAO;
    private ExercicioAdapter exercicioAdapter;
    private Treino treino;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.treino_activity);
        fazInstanciacaoDosObjetos();
        setTitle(treino.getNome());
        inicializaExerciciosNaListView();
        ListView lvExercicios = findViewById(R.id.treino_activity_list_view);
        lvExercicios.setAdapter(exercicioAdapter);
    }

    private void fazInstanciacaoDosObjetos() {
        exercicioDAO = new ExercicioDAO();
        exercicioAdapter = new ExercicioAdapter(this);
        treino = new Treino("Treino A");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.treino_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (R.id.treino_activity_menu_op_iniciar_treino == itemId) {
            // lógica de habilitar os botes de completar exercicio
            exercicioAdapter.mostraBotoes();
        }
        return super.onOptionsItemSelected(item);
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
        ex = new Exercicio();
        ex.setCarga(60.0F);
        ex.setSeries(3);
        ex.setRepeticoes(12);
        ex.setNome("leg press");
        exercicioDAO.adiciona(ex);
        treino.setExercicios(exercicioDAO.findAll());
    }
}
