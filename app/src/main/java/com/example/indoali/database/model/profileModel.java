package com.example.indoali.database.model;

public class profileModel {
    public static final String
            TABELA_NOME = "profile";
    public static final String
            COLUNA_ID = "_id",
            COLUNA_NOME = "nome",
            COLUNA_EMAIL = "email",
            COLUNA_SENHA = "senha";

    public static final String CREATE_TABLE =
            "create table " + TABELA_NOME + " ("
                    + COLUNA_ID + " integer primary key autoincrement,"
                    + COLUNA_NOME + " String ,"
                    + COLUNA_EMAIL + " String ,"
                    + COLUNA_SENHA + " String "
                    + ");";

    public static final String
            DROP_TABLE = "drop table if exists " + TABELA_NOME + ";";

    private int _id;
    private String nome;
    private String email;
    private String senha;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
