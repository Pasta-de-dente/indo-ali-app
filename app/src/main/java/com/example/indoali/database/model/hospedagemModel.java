package com.example.indoali.database.model;

public class hospedagemModel {

    private static  final String
    TABELA_NOME ="hospedagem";
    private static  final String
            COLUNA_ID="_id",
            COLUNA_CUSTO_MEDIO_POR_NOITE="CustoMedioPorNoite",
            COLUNA_TOTAL_DE_NOITE="TotalNoite",
            COLUNA_TOTAL_QUARTOS="TotalQuartos",
            COLUNA_TOTAL_GASTO="TotalGastos";

    public static final String  CREATE_TABLE=
            "create table "+TABELA_NOME+" ("
                +COLUNA_ID+  " integer primary key autoincrement,"
                +COLUNA_CUSTO_MEDIO_POR_NOITE+  " double not null,"
                    +COLUNA_TOTAL_DE_NOITE+  " integer not null,"
                    +COLUNA_TOTAL_QUARTOS+  " integer not null,"
                    +COLUNA_TOTAL_GASTO+  " double not null"
                    +");";

    public static final String
        DROP_TABLE="drop table if exists " +TABELA_NOME+ ";";

    private int _ID;
    private double custoMedioPorNoite;
    private int TotalNoite;
    private int totalQuartos;
    private double totalGasto;

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public double getCustoMedioPorNoite() {
        return custoMedioPorNoite;
    }

    public void setCustoMedioPorNoite(double custoMedioPorNoite) {
        this.custoMedioPorNoite = custoMedioPorNoite;
    }

    public int getTotalNoite() {
        return TotalNoite;
    }

    public void setTotalNoite(int totalNoite) {
        TotalNoite = totalNoite;
    }

    public int getTotalQuartos() {
        return totalQuartos;
    }

    public void setTotalQuartos(int totalQuartos) {
        this.totalQuartos = totalQuartos;
    }

    public double getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(double totalGasto) {
        this.totalGasto = totalGasto;
    }
}
