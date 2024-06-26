package com.example.indoali.database.model;

import java.io.Serializable;

public class carroModel implements Serializable {

    public static final String
            TABELA_NOME = "carro";
    public static final String
            COLUNA_ID = "_id",
            COLUNA_TOTAL_ESTIMADO_KM = "TotalEstimadoKM",
            COLUNA_MEDIA_KM_LITRO = "MediaKMLitro",
            COLUNA_CUSTO_MEDIO_LITRO = "CustoMedioLitro",
            COLUNA_TOTAL_VEICULO = "TotalVeiculos";

    public static final String CREATE_TABLE =
            "create table " + TABELA_NOME + " ("
                    + COLUNA_ID + " integer primary key autoincrement,"
                    + COLUNA_TOTAL_ESTIMADO_KM + " double,"
                    + COLUNA_MEDIA_KM_LITRO + " double,"
                    + COLUNA_CUSTO_MEDIO_LITRO + " double,"
                    + COLUNA_TOTAL_VEICULO + " integer "
                    + ");";

    public static final String
            DROP_TABLE = "drop table if exists " + TABELA_NOME + ";";

    private int _id;
    private double TotalEstimadoKm;
    private double MediaKmLitro;
    private double custoMedioLitro;
    private int TotalVeiculo;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public double getTotalEstimadoKm() {
        return TotalEstimadoKm;
    }

    public void setTotalEstimadoKm(double totalEstimadoKm) {
        TotalEstimadoKm = totalEstimadoKm;
    }

    public double getMediaKmLitro() {
        return MediaKmLitro;
    }

    public void setMediaKmLitro(double mediaKmLitro) {
        MediaKmLitro = mediaKmLitro;
    }

    public double getCustoMedioLitro() {
        return custoMedioLitro;
    }

    public void setCustoMedioLitro(double custoMedioLitro) {
        this.custoMedioLitro = custoMedioLitro;
    }

    public int getTotalVeiculo() {
        return TotalVeiculo;
    }

    public void setTotalVeiculo(int totalVeiculo) {
        TotalVeiculo = totalVeiculo;
    }
}
