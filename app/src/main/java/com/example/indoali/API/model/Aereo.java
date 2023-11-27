package com.example.indoali.API.model;

import java.io.Serializable;

public class Aereo implements Serializable {
    private double custoPessoa;
    private double custoAluguelVeiculo;

    public Aereo() {

    }

    public double getCustoPessoa() {
        return custoPessoa;
    }

    public void setCustoPessoa(double custoPessoa) {
        this.custoPessoa = custoPessoa;
    }

    public double getCustoAluguelVeiculo() {
        return custoAluguelVeiculo;
    }

    public void setCustoAluguelVeiculo(double custoAluguelVeiculo) {
        this.custoAluguelVeiculo = custoAluguelVeiculo;
    }
}
