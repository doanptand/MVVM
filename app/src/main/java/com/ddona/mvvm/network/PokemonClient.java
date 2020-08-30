package com.ddona.mvvm.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonClient {

    private static Retrofit INSTANCE;

    private PokemonClient() {

    }

    public static Retrofit getInstance(String baseUrl) {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return INSTANCE;
    }
}
