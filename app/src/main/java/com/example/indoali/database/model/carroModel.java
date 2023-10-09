package com.example.indoali.database.model;

public class carroModel {

    private static  final String
            TABELA_NOME ="carro";
    private static  final String
            COLUNA_ID="_id",
            COLUNA_TOTAL_ESTIMADO_KM="TotalEstimadoKM",
            COLUNA_MEDIA_KM_LITRO="MediaKMLitro",
            COLUNA_CUSTO_MEDIO_LITRO="CustoMedioLitro",
            COLUNA_TOTAL_VEICULO="TotalVeiculos";


    public static final String  CREATE_TABLE=
            "create table "+TABELA_NOME+" ("
                    +COLUNA_ID+  " integer primary key autoincrement,"
                    +   COLUNA_TOTAL_ESTIMADO_KM+  " double not null,"
                    +    COLUNA_MEDIA_KM_LITRO+  " double not null,"
                    +  COLUNA_CUSTO_MEDIO_LITRO+ " double not null"
                    +   COLUNA_TOTAL_VEICULO+ " integer not null"
                    +");";

    public static final String
            DROP_TABLE="drop table if exists " +TABELA_NOME+ ";";

    private int _id;
    private double TotalEstimadoKm;
    private double MediaKmLitro;
    private double custoMedioLitro;
    private double TotalVeiculo;

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

    public double getTotalVeiculo() {
        return TotalVeiculo;
    }

    public void setTotalVeiculo(double totalVeiculo) {
        TotalVeiculo = totalVeiculo;
    }
}
