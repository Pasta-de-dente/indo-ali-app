package com.example.indoali.database.model;

import java.io.Serializable;

public class viagemModel implements Serializable {

    public static final String
            TABELA_NOME = "viagem";
    public static final String
            COLUNA_ID = "_id",
            COLUNA_DESTINO = "destino",
            COLUNA_DATA = "data",
            COLUNA_DURACAO="duracao",
            COLUNA_QTDA_VIAJANTES="qtdaViajantes",
            COLUNA_ID_PROFILE = "_idProfile",
            COLUNA_ID_AVIAO = "_idTabelaAviao",
            COLUNA_ID_CARRO = "_idTabelaCarro",
            COLUNA_ID_REFEICAO = "_idTabelaRefeicao",
            COLUNA_ID_VIAGEM_ENTRETENIMENTO = "_idTabelaViagemToEntretenimento",
            COLUNA_ID_HOSPEDAGEM = "_idTabelaHospedagem";

    public static final String CREATE_TABLE =
            "create table " + TABELA_NOME + " ("
                    + COLUNA_ID + " integer primary key autoincrement, "
                    + COLUNA_DESTINO + " String not null, "
                    + COLUNA_DATA + " String not null, "
                    + COLUNA_DURACAO + " int not null, "
                    + COLUNA_QTDA_VIAJANTES + " int not null, "
                    + COLUNA_ID_PROFILE + " integer not null, "
                    + COLUNA_ID_AVIAO + " integer, "
                    + COLUNA_ID_CARRO + " integer, "
                    + COLUNA_ID_REFEICAO + " integer, "
                    + COLUNA_ID_VIAGEM_ENTRETENIMENTO + " integer, "
                    + COLUNA_ID_HOSPEDAGEM + " integer "
                    + ");";

    public static final String
            DROP_TABLE = "drop table if exists " + TABELA_NOME + ";";

    private int ID;
    private String destino;
    private String data;
    private int idProfile;
    private int idCarro;
    private int idAviao;
    private int idRefeicao;
    private int idHospedagem;
    private int idViagemToEntretenimento;

    private int qtdaViajante;

    private int duracao;

    public int getQtdaViajante() {
        return qtdaViajante;
    }

    public void setQtdaViajante(int qtdaViajante) {
        this.qtdaViajante = qtdaViajante;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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

    public int getIdViagemToEntretenimento() {
        return idViagemToEntretenimento;
    }

    public void setIdViagemToEntretenimento(int idViagemToEntretenimento) {
        this.idViagemToEntretenimento = idViagemToEntretenimento;
    }
}
