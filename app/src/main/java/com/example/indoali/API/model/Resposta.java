package com.example.indoali.API.model;

import java.io.Serializable;

public class Resposta implements Serializable {
    private boolean sucesso;
    private String Mensagem;
    private int ChavePrimaria;

    public Resposta() {

    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        Mensagem = mensagem;
    }

    public int getChavePrimaria() {
        return ChavePrimaria;
    }

    public void setChavePrimaria(int chavePrimaria) {
        ChavePrimaria = chavePrimaria;
    }
}
