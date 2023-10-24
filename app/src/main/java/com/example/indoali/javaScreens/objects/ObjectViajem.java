package com.example.indoali.javaScreens.objects;

import java.io.Serializable;
import java.util.List;

public class ObjectViajem implements Serializable {


    public void RemoverObjectViajem() {
        this.TotalViajanteAviao = 0;
        this.TotalViajanteRefeicao = 0;
        this.DuraçãodaViagem = 0;
        this.listaViajens.clear();
        this.listEntretenimento.clear();
        this.CustoPorPessoa = 0.0;
        this.AluguelVeiculo = 0.0;
        this.TotalEstimadoKm = 0.0;
        this.MediaKmLitro = 0.0;
        this.custoMedioLitro = 0.0;
        this.TotalVeiculo = 0;
        this.custoMedioPorNoite = 0.0;
        this.TotalNoite = 0;
        this.totalQuartos = 0;
        this.custoTotal = 0.0;
        this.CustoEstimadoPorRefeicao = 0.0;
        this.qtdaRefeicaoPorDia = 0;
        this.destinario = "";
        this.data = "";

    }

    private int TotalViajanteAviao = 0;
    private int TotalViajanteRefeicao = 0;
    private int DuraçãodaViagem = 0;

    public int getTotalViajanteAviao() {
        return TotalViajanteAviao;
    }

    public void setTotalViajanteAviao(int totalViajanteAviao) {
        TotalViajanteAviao = totalViajanteAviao;
    }

    public int getTotalViajanteRefeicao() {
        return TotalViajanteRefeicao;
    }

    public void setTotalViajanteRefeicao(int totalViajanteRefeicao) {
        TotalViajanteRefeicao = totalViajanteRefeicao;
    }

    public int getDuraçãodaViagem() {
        return DuraçãodaViagem;
    }

    public void setDuraçãodaViagem(int duraçãodaViagem) {
        DuraçãodaViagem = duraçãodaViagem;
    }

    private int KEY_ID_PROFILE;
    private String KEY_NOME_PROFILE;
    private String KEY_EMAIL_PROFILE;
    List<ObjectViajem> listaViajens;

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

    public List<entretenimento> listEntretenimento;

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
    private double custoMedioLitro = 0.0;
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

    private double custoMedioPorNoite = 0.0;
    private int TotalNoite = 0;
    private int totalQuartos = 0;


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

    private String destinario = "";
    private String data = "";
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

