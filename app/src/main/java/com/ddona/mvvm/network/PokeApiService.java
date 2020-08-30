package com.ddona.mvvm.network;

import com.ddona.mvvm.model.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApiService {
    @GET("pokemon")
    Call<PokemonResponse> getPokemons();
}