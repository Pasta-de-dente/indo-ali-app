package com.example.indoali.javaScreens.objects;

import java.io.Serializable;

public class ObjectViajem implements Serializable {

    private int _id;
    private Double CustoPorPessoa;
    private Double AluguelVeiculo;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Double getCustoPorPessoa() {
        return CustoPorPessoa;
    }

    public void setCustoPorPessoa(Double custoPorPessoa) {
        CustoPorPessoa = custoPorPessoa;
    }

    public Double getAluguelVeiculo() {
        return AluguelVeiculo;
    }

    public void setAluguelVeiculo(Double aluguelVeiculo) {
        AluguelVeiculo = aluguelVeiculo;
    }

    private double TotalEstimadoKm;
    private double MediaKmLitro;
    private double custoMedioLitro;
    private int TotalVeiculo;


    public double getTotalEstimadoKm() {
        return TotalEstimadoKm;
    }

    public void setTotalEstimadoKm(double totalEstimadoKm) {
        TotalEstimadoKm = totalEstimadoKm;
    }

    public double getMediaKmLitro() {
        return MediaKmLitro;
    }

    public void setMediaKmLitro(double mediaKmLitro) {
        MediaKmLitro = mediaKmLitro;
    }

    public double getCustoMedioLitro() {
        return custoMedioLitro;
    }

    public void setCustoMedioLitro(double custoMedioLitro) {
        this.custoMedioLitro = custoMedioLitro;
    }

    public int getTotalVeiculo() {
        return TotalVeiculo;
    }

    public void setTotalVeiculo(int totalVeiculo) {
        TotalVeiculo = totalVeiculo;
    }

    private String nomeEntretenimento;
    private double custoTotal;


    public String getNomeEntretenimento() {
        return nomeEntretenimento;
    }

    public void setNomeEntretenimento(String nomeEntretenimento) {
        this.nomeEntretenimento = nomeEntretenimento;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }
    private double custoMedioPorNoite;
    private int TotalNoite;
    private int totalQuartos;


    public double getCustoMedioPorNoite() {
        return custoMedioPorNoite;
    }

    public void setCustoMedioPorNoite(double custoMedioPorNoite) {
        this.custoMedioPorNoite = custoMedioPorNoite;
    }

    public int getTotalNoite() {
        return TotalNoite;
    }

    public void setTotalNoite(int totalNoite) {
        TotalNoite = totalNoite;
    }

    public int getTotalQuartos() {
        return totalQuartos;
    }

    public void setTotalQuartos(int totalQuartos) {
        this.totalQuartos = totalQuartos;
    }

    private double CustoEstimadoPorRefeicao;
    private int qtdaRefeicaoPorDia;



    public double getCustoEstimadoPorRefeicao() {
        return CustoEstimadoPorRefeicao;
    }

    public void setCustoEstimadoPorRefeicao(double custoEstimadoPorRefeicao) {
        CustoEstimadoPorRefeicao = custoEstimadoPorRefeicao;
    }

    public int getQtdaRefeicaoPorDia() {
        return qtdaRefeicaoPorDia;
    }

    public void setQtdaRefeicaoPorDia(int qtdaRefeicaoPorDia) {
        this.qtdaRefeicaoPorDia = qtdaRefeicaoPorDia;
    }
    private String destinario;
    private String data;
    private int idCarro;
    private int idAviao;
    private int idRefeicao;
    private int idHospedagem;
    private int idEntretenimento;

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

