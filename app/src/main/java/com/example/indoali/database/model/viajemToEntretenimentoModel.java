package com.example.indoali.database.model;

import java.io.Serializable;

public class viajemToEntretenimentoModel implements Serializable {

    public static  final String
            TABELA_NOME ="viajemEntretenimento";
    public static  final String
            COLUNA_ID="_id",
            COLUNA_DATA_VIAJEM="idDataViajem";

    public static final String  CREATE_TABLE=
            "create table "+TABELA_NOME+" ("
                    +COLUNA_ID+  " integer primary key autoincrement,"
                    +COLUNA_DATA_VIAJEM+  " integer not null "
                    +");";

    public int ID;
    public String DataViajem;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDataViajem() {
        return DataViajem;
    }

    public void setDataViajem(String dataViajem) {
        DataViajem = dataViajem;
    }

    public static final String
            DROP_TABLE="drop table if exists " +TABELA_NOME+ ";";
}
