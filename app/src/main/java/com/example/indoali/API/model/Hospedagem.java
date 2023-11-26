package com.example.indoali.API.model;


import java.io.Serializable;

public class Hospedagem implements Serializable {
    private double custoMedioNoite;
    private int totalNoite;
    private int totalQuartos;

    public Hospedagem() {

    }

    public double getCustoMedioNoite() {
        return custoMedioNoite;
    }

    public void setCustoMedioNoite(double custoMedioNoite) {
        this.custoMedioNoite = custoMedioNoite;
    }

    public int getTotalNoite() {
        return totalNoite;
    }

    public void setTotalNoite(int totalNoite) {
        this.totalNoite = totalNoite;
    }

    public int getTotalQuartos() {
        return totalQuartos;
    }

    public void setTotalQuartos(int totalQuartos) {
        this.totalQuartos = totalQuartos;
    }
}
