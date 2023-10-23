package com.example.indoali.database.model;

import java.io.Serializable;

public class viajemModel implements Serializable {

    public static  final String
    TABELA_NOME ="viajem";
    public static  final String
            COLUNA_ID="_id",
            COLUNA_DESTINO="destino",
            COLUNA_DATA="data",
            COLUNA_ID_PROFILE="_idProfile",
            COLUNA_ID_AVIAO="_idTabelaAviao",
            COLUNA_ID_CARRO="_idTabelaCarro",
            COLUNA_ID_REFEICAO="_idTabelaRefeicao",
            COLUNA_ID_VIAJEM_ENTRETENIMENTO="_idTabelaViajemToEntretenimento",
            COLUNA_ID_HOSPEDAGEM="_idTabelaHospedagem";

    public static final String  CREATE_TABLE=
            "create table "+TABELA_NOME+" ("
                    +COLUNA_ID+  " integer primary key autoincrement, "
                    +COLUNA_DESTINO+" String not null,"
                    +COLUNA_DATA+" String not null,"
                    +COLUNA_ID_PROFILE+" integer,"
                    +COLUNA_ID_AVIAO+  " integer,"
                    +COLUNA_ID_CARRO+  " integer,"
                    +COLUNA_ID_REFEICAO+  " integer,"
                    +COLUNA_ID_VIAJEM_ENTRETENIMENTO+  " integer,"
                    +COLUNA_ID_HOSPEDAGEM +  " integer "
                    +");";

    public static final String
        DROP_TABLE="drop table if exists " +TABELA_NOME+ ";";

    private int ID;
    private String destinario;
    private String data;

    private int idProfile;
    private int idCarro;
    private int idAviao;
    private int idRefeicao;
    private int idHospedagem;
    private int idViajemToEntretenimento;

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

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
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

    public int getIdViajemToEntretenimento() {
        return idViajemToEntretenimento;
    }

    public void setIdViajemToEntretenimento(int idViajemToEntretenimento) {
        this.idViajemToEntretenimento =idViajemToEntretenimento;
    }
}
