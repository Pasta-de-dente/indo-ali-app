package com.example.indoali.database.model;

import java.io.Serializable;

public class viagemToEntretenimentoModel implements Serializable {

    public static final String
            TABELA_NOME = "viagemEntretenimento";
    public static final String
            COLUNA_ID = "_id",
            COLUNA_DATA_VIAGEM = "idDataViagem";

    public static final String CREATE_TABLE =
            "create table " + TABELA_NOME + " ("
                    + COLUNA_ID + " integer primary key autoincrement,"
                    + COLUNA_DATA_VIAGEM + " integer not null "
                    + ");";

    public int ID;
    public String DataViagem;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDataViagem() {
        return DataViagem;
    }

    public void setDataViagem(String dataViagem) {
        DataViagem = dataViagem;
    }

    public static final String
            DROP_TABLE = "drop table if exists " + TABELA_NOME + ";";
}
