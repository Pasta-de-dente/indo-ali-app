package com.example.indoali.database.model;

public class viajemModel {

    private static  final String
    TABELA_NOME ="viajem";
    public static  final String
            COLUNA_ID="_id",
            COLUNA_ID_AVIAO="_idTabelaAviao",
            COLUNA_ID_CARRO="_idTabelaCarro",
            COLUNA_ID_REFEICAO="_idTabelaRefeicao",
            COLUNA_ID_ENTRETENIMENTO="_idTabelaEntretenimento",
            COLUNA_ID_HOSPEDAGEM="_idTabelaHospedagem";

    public static final String  CREATE_TABLE=
            "create table "+TABELA_NOME+" ("
                +COLUNA_ID+  " integer primary key autoincrement,"
                +COLUNA_ID_AVIAO+  " integer not null,"
                    +COLUNA_ID_CARRO+  " integer not null,"
                    +COLUNA_ID_REFEICAO+  " integer not null,"
                    +COLUNA_ID_ENTRETENIMENTO+  " integer not null,"
                    +COLUNA_ID_HOSPEDAGEM +  " integer not null"
                    +");";

    public static final String
        DROP_TABLE="drop table if exists " +TABELA_NOME+ ";";
}
