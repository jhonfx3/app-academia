package com.example.prjacademia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
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
        TextView txtNomeEx = viewCriada.findViewById(R.id.treino_activity_item_nome_exercicio);
        EditText txtCargaEx = viewCriada.findViewById(R.id.treino_activity_item_carga);
        EditText txtRepeticoesEx = viewCriada.findViewById(R.id.treino_activity_item_repeticoes);
        EditText txtSeriesEx = viewCriada.findViewById(R.id.treino_activity_item_series);

        setaAsInformacoesNasViews(posicao, txtNomeEx, txtCargaEx, txtRepeticoesEx, txtSeriesEx);

        configuraEventoDoBotao(viewCriada);
    }

    private void configuraEventoDoBotao(View viewCriada) {
        Button botao = viewCriada.findViewById(R.id.treino_activity_item_botao_exercicio);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoBotao = (String) botao.getText();
                if (textoBotao.contains("Completar")) {
                    botao.setText("Reiniciar exercicio");
                } else {
                    botao.setText("Completar exercicio");
                }
            }
        });
    }

    private void setaAsInformacoesNasViews(int posicao, TextView txtNomeEx, EditText txtCargaEx, EditText txtRepeticoesEx, EditText txtSeriesEx) {
        Exercicio exercicio = exercicios.get(posicao);
        txtNomeEx.setText(exercicio.getNome());
        txtCargaEx.setText(String.valueOf(exercicio.getCarga()));
        txtRepeticoesEx.setText(String.valueOf(exercicio.getRepeticoes()));
        txtSeriesEx.setText(String.valueOf(exercicio.getSeries()));
        txtSeriesEx.setEnabled(false);
        txtRepeticoesEx.setEnabled(false);
    }

    public void atualizaDados(List<Exercicio> exercicios) {
        this.exercicios.clear();
        this.exercicios.addAll(exercicios);
        notifyDataSetChanged();
    }
}
