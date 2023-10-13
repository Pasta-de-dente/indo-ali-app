package com.example.indoali.database.model;

import java.io.Serializable;

public class viajemModel implements Serializable {

    private static  final String
    TABELA_NOME ="viajem";
    public static  final String
            COLUNA_ID="_id",
            COLUNA_DESTINO="destino",
            COLUNA_DATA="data",
            COLUNA_ID_AVIAO="_idTabelaAviao",
            COLUNA_ID_CARRO="_idTabelaCarro",
            COLUNA_ID_REFEICAO="_idTabelaRefeicao",
            COLUNA_ID_ENTRETENIMENTO="_idTabelaEntretenimento",
            COLUNA_ID_HOSPEDAGEM="_idTabelaHospedagem";

    public static final String  CREATE_TABLE=
            "create table "+TABELA_NOME+" ("
                    +COLUNA_ID+  " integer primary key autoincrement,"
                    +COLUNA_DESTINO+"String not null,"
                    +COLUNA_DATA+"String not null,"
                    +COLUNA_ID_AVIAO+  " integer not null,"
                    +COLUNA_ID_CARRO+  " integer not null,"
                    +COLUNA_ID_REFEICAO+  " integer not null,"
                    +COLUNA_ID_ENTRETENIMENTO+  " integer not null,"
                    +COLUNA_ID_HOSPEDAGEM +  " integer not null "
                    +");";

    public static final String
        DROP_TABLE="drop table if exists " +TABELA_NOME+ ";";

    private int ID;
    private String destinario;
    private String data;
    private int idCarro;
    private int idAviao;
    private int idRefeicao;
    private int idHospedagem;
    private int idEntretenimento;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDestinario() {
        return destinario;
    }

    public void setDestinario(String destinario) {
        this.destinario = destinario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public int getIdAviao() {
        return idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public int getIdRefeicao() {
        return idRefeicao;
    }

    public void setIdRefeicao(int idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public int getIdHospedagem() {
        return idHospedagem;
    }

    public void setIdHospedagem(int idHospedagem) {
        this.idHospedagem = idHospedagem;
    }

    public int getIdEntretenimento() {
        return idEntretenimento;
    }

    public void setIdEntretenimento(int idEntretenimento) {
        this.idEntretenimento = idEntretenimento;
    }
}
