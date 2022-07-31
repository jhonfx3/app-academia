package com.example.prjacademia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.prjacademia.R;
import com.example.prjacademia.model.Exercicio;

import java.util.ArrayList;
import java.util.List;

public class ExercicioAdapter extends BaseAdapter {
    private List<Exercicio> exercicios = new ArrayList<Exercicio>();
    private Context context;

    public ExercicioAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return exercicios.size();
    }

    @Override
    public Exercicio getItem(int posicao) {
        return exercicios.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return exercicios.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater.
                from(context).inflate(R.layout.item_exercicio, viewGroup, false);
        setaOsDadosNasTextViews(posicao, viewCriada);
        return viewCriada;
    }

    private void setaOsDadosNasTextViews(int posicao, View viewCriada) {
        TextView txtNomeExercicio = viewCriada.findViewById(R.id.treino_activity_item_nome_exercicio);
        TextView txtCargaExercicio = viewCriada.findViewById(R.id.treino_activity_item_carga);
        Button botao = viewCriada.findViewById(R.id.treino_activity_item_botao_exercicio);
        Exercicio exercicio = exercicios.get(posicao);
        txtNomeExercicio.setText(exercicio.getNome());
        txtCargaExercicio.setText(String.valueOf(exercicio.getCarga()));
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoBotao = (String) botao.getText();
                if(textoBotao.contains("Completar")){
                    botao.setText("Reiniciar exercicio");
                }else{
                    botao.setText("Completar exercicio");
                }
            }
        });
    }

    public void atualizaDados(List<Exercicio> exercicios) {
        this.exercicios.clear();
        this.exercicios.addAll(exercicios);
        notifyDataSetChanged();
    }
}
