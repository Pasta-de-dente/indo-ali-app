package com.example.indoali.database.model;

import java.io.Serializable;

public class refeicaoModel implements Serializable {

    public static final String
            TABELA_NOME = "refeicao";
    public static final String
            COLUNA_ID = "_id",
            COLUNA_CUSTO_ESTIMADO_POR_REFEICAO = "custoEstimadoPorRefeicao",
            COLUNA_QTDA_REFEICAO_POR_DIA = "QtdaRefeicaoPorDia",

    COLUNA_VIAJANTE_POR_REFEICAO = "ViajanteRefeicao",
            COLUNA_DURACAO_VIAGEM = "ViagemDuracao";

    public static final String CREATE_TABLE =
            "create table " + TABELA_NOME + " ("
                    + COLUNA_ID + " integer primary key autoincrement,"
                    + COLUNA_CUSTO_ESTIMADO_POR_REFEICAO + " double ,"
                    + COLUNA_QTDA_REFEICAO_POR_DIA + " integer, "
                    + COLUNA_DURACAO_VIAGEM + " integer ,"
                    + COLUNA_VIAJANTE_POR_REFEICAO + " integer "
                    + ");";

    public static final String
            DROP_TABLE = "drop table if exists " + TABELA_NOME + ";";

    private int _ID;
    private double CustoEstimadoPorRefeicao;
    private int qtdaRefeicaoPorDia;

    private int ViajantePorRefeicao;

    public int getViajantePorRefeicao() {
        return ViajantePorRefeicao;
    }

    public void setViajantePorRefeicao(int viajantePorRefeicao) {
        ViajantePorRefeicao = viajantePorRefeicao;
    }

    private int DuracaoViagem;

    public int getDuracaoViagem() {
        return DuracaoViagem;
    }

    public void setDuracaoViagem(int duracaoViagem) {
        DuracaoViagem = duracaoViagem;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public double getCustoEstimadoPorRefeicao() {
        return CustoEstimadoPorRefeicao;
    }

    public void setCustoEstimadoPorRefeicao(double custoEstimadoPorRefeicao) {
        CustoEstimadoPorRefeicao = custoEstimadoPorRefeicao;
    }

    public int getQtdaRefeicaoPorDia() {
        return qtdaRefeicaoPorDia;
    }

    public void setQtdaRefeicaoPorDia(int qtdaRefeicaoPorDia) {
        this.qtdaRefeicaoPorDia = qtdaRefeicaoPorDia;
    }


}
