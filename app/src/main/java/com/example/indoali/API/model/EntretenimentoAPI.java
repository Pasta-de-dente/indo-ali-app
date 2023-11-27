package com.example.indoali.API.model;

import java.io.Serializable;

public class EntretenimentoAPI implements Serializable {
    private double valor;
    private String entretenimento;

    public EntretenimentoAPI(){

    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEntretenimento() {
        return entretenimento;
    }

    public void setEntretenimento(String entretenimento) {
        this.entretenimento = entretenimento;
    }
}
