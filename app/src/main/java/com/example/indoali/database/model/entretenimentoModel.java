package com.example.indoali.database.model;

public class entretenimentoModel {

    private static  final String
            TABELA_NOME ="aviao";
    private static  final String
            COLUNA_ID="_id",
            COLUNA_CUSTO_POR_PESSOA="CustoEstimadoPessoa",
            COLUNA_ALUGUEL_VEICULO="AluguelVeiculos",
            COLUNA_TOTAL_GASTO="TotalGasto";

    public static final String  CREATE_TABLE=
            "create table "+TABELA_NOME+" ("
                    +COLUNA_ID+  " integer primary key autoincrement,"
                    +    COLUNA_CUSTO_POR_PESSOA+  " double not null,"
                    +    COLUNA_ALUGUEL_VEICULO+  " double not null,"
                    +  COLUNA_TOTAL_GASTO+ " double not null"

                    +");";

    public static final String
            DROP_TABLE="drop table if exists " +TABELA_NOME+ ";";


    private int _ID;
    private double CustoPorPessoa;
    private double AluguelVeiculo;
    private double TotalGasto;

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public double getCustoPorPessoa() {
        return CustoPorPessoa;
    }

    public void setCustoPorPessoa(double custoPorPessoa) {
        CustoPorPessoa = custoPorPessoa;
    }

    public double getAluguelVeiculo() {
        return AluguelVeiculo;
    }

    public void setAluguelVeiculo(double aluguelVeiculo) {
        AluguelVeiculo = aluguelVeiculo;
    }

    public double getTotalGasto() {
        return TotalGasto;
    }

    public void setTotalGasto(double totalGasto) {
        TotalGasto = totalGasto;
    }
}
