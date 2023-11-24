package com.example.indoali.API.model;

import java.io.Serializable;
import java.util.ArrayList;

public class EnviarViagem implements Serializable {
    public EnviarViagem() {

    }

    private CustoAereoModel custoAereoModel;
    private CustoEntretenimentoModel custoEntretenimentoModel;
    public ArrayList<CustoEntretenimentoModel> custoEntretenimentoModels = new ArrayList<CustoEntretenimentoModel>();
    private CustoGasolinaModel custoGasolinaModel;
    private CustoHospedagemModel custoHospedagemModel;
    private CustoRefeicaoModel custoRefeicaoModel;
    private ViagemModel viagemModel;

    public CustoAereoModel getCustoAereoModel() {
        return custoAereoModel;
    }

    public void setCustoAereoModel(CustoAereoModel custoAereoModel) {
        this.custoAereoModel = custoAereoModel;
    }

    public CustoEntretenimentoModel getCustoEntretenimentoModel() {
        return custoEntretenimentoModel;
    }

    public void setCustoEntretenimentoModel(CustoEntretenimentoModel custoEntretenimentoModel) {
        this.custoEntretenimentoModel = custoEntretenimentoModel;
    }

    public CustoGasolinaModel getCustoGasolinaModel() {
        return custoGasolinaModel;
    }

    public void setCustoGasolinaModel(CustoGasolinaModel custoGasolinaModel) {
        this.custoGasolinaModel = custoGasolinaModel;
    }

    public CustoHospedagemModel getCustoHospedagemModel() {
        return custoHospedagemModel;
    }

    public void setCustoHospedagemModel(CustoHospedagemModel custoHospedagemModel) {
        this.custoHospedagemModel = custoHospedagemModel;
    }

    public CustoRefeicaoModel getCustoRefeicaoModel() {
        return custoRefeicaoModel;
    }

    public void setCustoRefeicaoModel(CustoRefeicaoModel custoRefeicaoModel) {
        this.custoRefeicaoModel = custoRefeicaoModel;
    }

    public ViagemModel getViagemModel() {
        return viagemModel;
    }

    public void setViagemModel(ViagemModel viagemModel) {
        this.viagemModel = viagemModel;
    }
}
