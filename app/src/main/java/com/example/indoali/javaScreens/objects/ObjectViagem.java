package com.example.indoali.javaScreens.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectViagem implements Serializable {
    private int TotalViajante = 0;

    private int DuracaoDaViagem = 0;

    public int getTotalViajante() {
        return TotalViajante;
    }

    public void setTotalViajante(int totalViajanteRefeicao) {
        TotalViajante = totalViajanteRefeicao;
    }

    public int getDuracaoDaViagem() {
        return DuracaoDaViagem;
    }

    public void setDuracaoDaViagem(int duracao) {
        DuracaoDaViagem = duracao;
    }

    private int KEY_ID_PROFILE;
    private String KEY_NOME_PROFILE;
    private String KEY_EMAIL_PROFILE;
    List<ObjectViagem> listaViagens;

    public int getKEY_ID_PROFILE() {
        return KEY_ID_PROFILE;
    }

    public void setKEY_ID_PROFILE(int KEY_ID_PROFILE) {
        this.KEY_ID_PROFILE = KEY_ID_PROFILE;
    }

    public String getKEY_NOME_PROFILE() {
        return KEY_NOME_PROFILE;
    }

    public void setKEY_NOME_PROFILE(String KEY_NOME_PROFILE) {
        this.KEY_NOME_PROFILE = KEY_NOME_PROFILE;
    }

    public String getKEY_EMAIL_PROFILE() {
        return KEY_EMAIL_PROFILE;
    }

    public void setKEY_EMAIL_PROFILE(String KEY_EMAIL_PROFILE) {
        this.KEY_EMAIL_PROFILE = KEY_EMAIL_PROFILE;
    }

    private int _id;
    private Double CustoPorPessoa = 0.0;
    private Double AluguelVeiculo = 0.0;

    public List<Entretenimento> listEntretenimento=new ArrayList<>();

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

    private double TotalEstimadoKm = 0.0;
    private double MediaKmLitro = 0.0;
    private double CustoMedioLitro = 0.0;
    private int TotalVeiculo = 0;

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
        return CustoMedioLitro;
    }

    public void setCustoMedioLitro(double custoMedioLitro) {
        this.CustoMedioLitro = custoMedioLitro;
    }

    public int getTotalVeiculo() {
        return TotalVeiculo;
    }

    public void setTotalVeiculo(int totalVeiculo) {
        TotalVeiculo = totalVeiculo;
    }

    private String nomeEntretenimento = "";
    private double custoTotal = 0.0;

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

    private double CustoMedioPorNoite = 0.0;
    private int TotalNoite = 0;
    private int totalQuartos = 0;

    public double getCustoMedioPorNoite() {
        return CustoMedioPorNoite;
    }

    public void setCustoMedioPorNoite(double custoMedioPorNoite) {
        this.CustoMedioPorNoite = custoMedioPorNoite;
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

    private double CustoEstimadoPorRefeicao = 0.0;
    private int qtdaRefeicaoPorDia = 0;

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

    private String destino = "";
    private String data = "";
    private int idCarro;
    private int idAviao;
    private int idRefeicao;
    private int idHospedagem;
    private int idEntretenimento;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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

