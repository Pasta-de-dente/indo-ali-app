package com.example.indoali.API;

import com.example.indoali.API.endpoint.ViagemEndpoint;
import com.example.indoali.API.model.EnviarViagem;
import com.example.indoali.API.model.Resposta;
import com.example.indoali.API.model.ViagemModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    public static final String URL_ROOT = "http://api.genialsaude.com.br/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL_ROOT)
            .addConverterFactory(GsonConverterFactory.create()).build();

    public static void getViagem(int viagemId, final Callback<Resposta> callback) {
        ViagemEndpoint endpoint = retrofit.create(ViagemEndpoint.class);
        Call<Resposta> call = endpoint.getViagem(viagemId);
        call.enqueue(callback);
    }

    public static void postViagem(EnviarViagem enviarViagem, final Callback<Resposta> callback) {
        ViagemEndpoint endpoint = retrofit.create(ViagemEndpoint.class);
        Call<Resposta> call = endpoint.postViagem(enviarViagem);
        call.enqueue(callback);
    }
}
