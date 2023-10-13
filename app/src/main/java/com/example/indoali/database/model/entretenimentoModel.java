package com.example.indoali.database.model;

import java.io.Serializable;

public class entretenimentoModel implements Serializable {

    public static  final String
            TABELA_NOME ="entretenimento";
    public static  final String
            COLUNA_ID="_id",
            COLUNA_NOME="nome",
            COLUNA_CUSTO_TOTAL="custoTotal";


    public static final String  CREATE_TABLE=
            "create table "+TABELA_NOME+" ("
                    +COLUNA_ID+  " integer primary key autoincrement,"
                    +    COLUNA_NOME+  " String not null,"
                    +    COLUNA_CUSTO_TOTAL+  " double not null "
                    +");";

    public static final String
            DROP_TABLE="drop table if exists " +TABELA_NOME+ ";";


   private int ID;
   private String nomeEntretenimento;
   private double custoTotal;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomeEntretenimento() {
        return nomeEntretenimento;
    }

    public void setNomeEntretenimento(String nomeEntretenimento) {
        this.nomeEntretenimento = nomeEntretenimento;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }
}
