package com.example.indoali.API.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ViagemModel implements Serializable {
    private int totalViajantes;
    private int duracaoViagem;
    private double custoTotalViagem;
    private double custoPorPessoa;
    private String local;
    private int idConta;

    private Aereo aereo;
    private Gasolina gasolina;
    private ArrayList<EntretenimentoModel> listaEntretenimentoModel;
    private Hospedagem hospedagem;
    private Refeicao refeicao;

    public ViagemModel() {

    }

    public int getTotalViajantes() {
        return totalViajantes;
    }

    public void setTotalViajantes(int totalViajantes) {
        this.totalViajantes = totalViajantes;
    }

    public int getDuracaoViagem() {
        return duracaoViagem;
    }

    public void setDuracaoViagem(int duracaoViagem) {
        this.duracaoViagem = duracaoViagem;
    }

    public double getCustoTotalViagem() {
        return custoTotalViagem;
    }

    public void setCustoTotalViagem(double custoTotalViagem) {
        this.custoTotalViagem = custoTotalViagem;
    }

    public double getCustoPorPessoa() {
        return custoPorPessoa;
    }

    public void setCustoPorPessoa(double custoPorPessoa) {
        this.custoPorPessoa = custoPorPessoa;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public Aereo getAereo() {
        return aereo;
    }

    public void setAereo(Aereo aereo) {
        this.aereo = aereo;
    }

    public Gasolina getGasolina() {
        return gasolina;
    }

    public void setGasolina(Gasolina gasolina) {
        this.gasolina = gasolina;
    }

    public ArrayList<EntretenimentoModel> getListaEntretenimento() {
        return listaEntretenimentoModel;
    }

    public void setListaEntretenimento(ArrayList<EntretenimentoModel> listaEntretenimentoModel) {
        this.listaEntretenimentoModel = listaEntretenimentoModel;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }
}
