package com.example.indoali.API.model;

import java.io.Serializable;

public class Refeicao implements Serializable {
    private double custoRefeicao;
    private int refeicoesDia;

    public Refeicao() {

    }

    public double getCustoRefeicao() {
        return custoRefeicao;
    }

    public void setCustoRefeicao(double custoRefeicao) {
        this.custoRefeicao = custoRefeicao;
    }

    public int getRefeicoesDia() {
        return refeicoesDia;
    }

    public void setRefeicoesDia(int refeicoesDia) {
        this.refeicoesDia = refeicoesDia;
    }
}
