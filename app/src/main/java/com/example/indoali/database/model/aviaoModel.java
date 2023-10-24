package com.example.indoali.database.model;

public class aviaoModel {

    public static final String
            TABELA_NOME = "aviao";
    public static final String
            COLUNA_ID = "_id",
            COLUNA_CUSTO_POR_PESSOA = "CustoEstimadoPessoa",
            COLUNA_TOTAL_VIAJANTE_AVIAO = "TotalViajante",
            COLUNA_ALUGUEL_VEICULO = "AluguelVeiculosAviao";

    public static final String CREATE_TABLE =
            "create table " + TABELA_NOME + " ("
                    + COLUNA_ID + " integer primary key autoincrement,"
                    + COLUNA_CUSTO_POR_PESSOA + " double, "
                    + COLUNA_ALUGUEL_VEICULO + " double, "
                    + COLUNA_TOTAL_VIAJANTE_AVIAO + " integer  "
                    + ");";

    public static final String
            DROP_TABLE = "drop table if exists " + TABELA_NOME + ";";

    private int _id;
    private Double CustoPorPessoa;
    private Double AluguelVeiculo;
    private int TotalViajanteAviao;

    public int getTotalViajanteAviao() {
        return TotalViajanteAviao;
    }

    public void setTotalViajanteAviao(int totalViajanteAviao) {
        TotalViajanteAviao = totalViajanteAviao;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Double getCustoPorPessoa() {
        return CustoPorPessoa;
    }

    public void setCustoPorPessoa(Double custoPorPessoa) {
        CustoPorPessoa = custoPorPessoa;
    }

    public Double getAluguelVeiculo() {
        return AluguelVeiculo;
    }

    public void setAluguelVeiculo(Double aluguelVeiculo) {
        AluguelVeiculo = aluguelVeiculo;
    }


}
