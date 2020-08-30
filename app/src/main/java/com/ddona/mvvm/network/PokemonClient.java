package com.ddona.mvvm.network;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
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
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())//for rxAndroid with Retrofit
                    .build();
        }
        return INSTANCE;
    }
}
