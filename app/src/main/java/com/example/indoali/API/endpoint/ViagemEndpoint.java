package com.example.indoali.API.endpoint;

import com.example.indoali.API.model.ViagemModel;
import com.example.indoali.API.model.Resposta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ViagemEndpoint {
    @POST("api/cadastro/viagem")
    Call<Resposta> postViagem(@Body ViagemModel viagemModel);

    @GET("api/listar/viagem/conta")
    Call<ArrayList<ViagemModel>> getViagem(@Query("contaId") int contaId);
}
