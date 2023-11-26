package com.example.indoali.API.model;

import java.io.Serializable;

public class Resposta implements Serializable {
    private boolean sucesso;
    private int dados;
    private String mensagem;
    private int chavePrimaria;

    public Resposta() {

    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public int getDados() {
        return dados;
    }

    public void setDados(int dados) {
        this.dados = dados;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getChavePrimaria() {
        return chavePrimaria;
    }

    public void setChavePrimaria(int chavePrimaria) {
        this.chavePrimaria = chavePrimaria;
    }
}
