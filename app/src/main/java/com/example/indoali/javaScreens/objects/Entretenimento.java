package com.example.indoali.javaScreens.objects;

import java.io.Serializable;

public class Entretenimento implements Serializable {
    public String nome;
    public double preco;
    public int qtdaPessoas;
    public int qtdaVezes;

    public int idViagemToEntretenimento;

    public Entretenimento() {

    }

    public int getIdViagemToEntretenimento() {
        return idViagemToEntretenimento;
    }

    public void setIdViagemToEntretenimento(int idViagemToEntretenimento) {
        this.idViagemToEntretenimento = idViagemToEntretenimento;
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

    public int getQtdaPessoas() {
        return qtdaPessoas;
    }

    public void setQtdaPessoas(int qtdaPessoas) {
        this.qtdaPessoas = qtdaPessoas;
    }

    public int getQtdaVezes() {
        return qtdaVezes;
    }

    public void setQtdaVezes(int qtdaVezes) {
        this.qtdaVezes = qtdaVezes;
    }
}