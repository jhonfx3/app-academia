package com.example.prjacademia.model;

public class Exercicio {
    private Integer series;
    private Integer repeticoes;
    private Float carga;

    public void setSeries(Integer series) {
        this.series = series;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    public void setCarga(Float carga) {
        this.carga = carga;
    }

    public Integer getSeries() {
        return series;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public Float getCarga() {
        return carga;
    }
}
