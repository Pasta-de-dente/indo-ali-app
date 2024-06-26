package com.example.indoali.database.model;

import java.io.Serializable;

public class entretenimentoModel implements Serializable {

    public static final String
            TABELA_NOME = "entretenimento";
    public static final String
            COLUNA_ID = "_id",
            COLUNA_NOME = "nome",
            COLUNA_PRECO = "preco",
            COLUNA_QTDA_VEZES = "qtdaVezes",
            COLUNA_QTDA_PESSOAS = "qtdaPessoas",
            COLUNA_ID_VIAGEM = "id_viagemToEntretenimento";


    public static final String CREATE_TABLE =
            "create table " + TABELA_NOME + " ("
                    + COLUNA_ID + " integer primary key autoincrement,"
                    + COLUNA_NOME + " String,"
                    + COLUNA_PRECO + " String,"
                    + COLUNA_QTDA_PESSOAS + " String,"
                    + COLUNA_QTDA_VEZES + " String, "
                    + COLUNA_ID_VIAGEM + " integer not null "
                    + ");";

    public static final String
            DROP_TABLE = "drop table if exists " + TABELA_NOME + ";";

    public int ID;
    public String nome;
    public double preco;
    public double qtdaVezes;
    public double qtdaPessoas;
    public int idViagemToEntretenimento;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQtdaVezes() {
        return qtdaVezes;
    }

    public void setQtdaVezes(double qtdaVezes) {
        this.qtdaVezes = qtdaVezes;
    }

    public double getQtdaPessoas() {
        return qtdaPessoas;
    }

    public int getIdViagemToEntretenimento() {
        return idViagemToEntretenimento;
    }

    public void setIdViagemToEntretenimento(int idViagemToEntretenimento) {
        this.idViagemToEntretenimento = idViagemToEntretenimento;
    }

    public void setQtdaPessoas(double qtdaPessoas) {
        this.qtdaPessoas = qtdaPessoas;
    }
}