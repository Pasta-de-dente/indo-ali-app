package com.example.indoali.database.model;

import java.io.Serializable;

public class viajemToEntretenimentoModel implements Serializable {

    public static  final String
            TABELA_NOME ="viajemEntretenimento";
    public static  final String
            COLUNA_ID="_id",
            COLUNA_ID_VIAJEM_ENTRETENIMENTO="idTabelaViajemEntretenimento";

    public static final String  CREATE_TABLE=
            "create table "+TABELA_NOME+" ("
                    +COLUNA_ID+  " integer primary key autoincrement,"
                    +COLUNA_ID_VIAJEM_ENTRETENIMENTO+  " integer not null "
                    +");";

    public int ID;
    public int ID_VIAJEM_ENTRETENIMENTO;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_VIAJEM_ENTRETENIMENTO() {
        return ID_VIAJEM_ENTRETENIMENTO;
    }

    public void setID_VIAJEM_ENTRETENIMENTO(int ID_VIAJEM_ENTRETENIMENTO) {
        this.ID_VIAJEM_ENTRETENIMENTO = ID_VIAJEM_ENTRETENIMENTO;
    }
    public static final String
            DROP_TABLE="drop table if exists " +TABELA_NOME+ ";";
}
