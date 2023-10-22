package com.example.indoali.database.model;

import java.io.Serializable;

public class entretenimentoModel implements Serializable {

    public static  final String
            TABELA_NOME ="entretenimento";
    public static  final String
            COLUNA_ID="_id",
            COLUNA_NOME="nome",
            COLUNA_PRECO="preco",
            COLUNA_QTDA_VEZES="qtdaVezes",
            COLUNA_QTDA_PESSOAS="qtdaPessoas",
            COLUNA_ID_VIAJEM = "id_viajemToEntretenimento";


    public static final String  CREATE_TABLE=
            "create table "+TABELA_NOME+" ("
                    +    COLUNA_ID+  " integer primary key autoincrement,"
                    +    COLUNA_NOME+  " String not null,"
                    +    COLUNA_PRECO+  " String not null,"
                    +    COLUNA_QTDA_PESSOAS+  " String not null,"
                    +    COLUNA_QTDA_VEZES+  " String not null, "
                    +    COLUNA_ID_VIAJEM + " integer not null "
                    +");";

    public static final String
            DROP_TABLE="drop table if exists " +TABELA_NOME+ ";";

    public int ID;
    public String nome;
    public double preco;
    public double qtdaVezes;
    public double qtdaPessoas;
    public int idViajemToEntretenimento;
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

    public int getIdViajemToEntretenimento() {
        return idViajemToEntretenimento;
    }

    public void setIdViajemToEntretenimento(int idViajemToEntretenimento) {
        this.idViajemToEntretenimento = idViajemToEntretenimento;
    }

    public void setQtdaPessoas(double qtdaPessoas) {
        this.qtdaPessoas = qtdaPessoas;
    }
}
