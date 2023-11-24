package com.example.indoali.API.endpoint;

import com.example.indoali.API.model.EnviarViagem;
import com.example.indoali.API.model.Resposta;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ViagemEndpoint {
    @GET("api/listar/viagem/{viagemId}")
    Call<Resposta> getViagem(@Path("viagemId") int viagemId);

    @POST("api/cadastro/viagem")
    Call<Resposta> postViagem(@Body EnviarViagem enviarViagem);
}
