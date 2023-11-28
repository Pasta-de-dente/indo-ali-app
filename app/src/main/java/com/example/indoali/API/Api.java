package com.example.indoali.API;

import com.example.indoali.API.endpoint.ViagemEndpoint;
import com.example.indoali.API.model.ViagemModel;
import com.example.indoali.API.model.Resposta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    public static final String URL_ROOT = "http://api.genialsaude.com.br/";
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL_ROOT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static void postViagem(ViagemModel viagemModel, final Callback<Resposta> callback) {
        ViagemEndpoint endpoint = retrofit.create(ViagemEndpoint.class);
        Call<Resposta> call = endpoint.postViagem(viagemModel);
        call.enqueue(callback);
    }

    public static void getViagem(int contaId, final Callback<ArrayList<ViagemModel>> callback) {
        ViagemEndpoint endpoint = retrofit.create(ViagemEndpoint.class);
        Call<ArrayList<ViagemModel>> call = endpoint.getViagem(contaId);
        call.enqueue(callback);
    }
}
