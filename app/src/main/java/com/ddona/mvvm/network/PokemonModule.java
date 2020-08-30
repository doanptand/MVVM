package com.ddona.mvvm.network;

import com.ddona.mvvm.util.Const;

public class PokemonModule {

    private static PokeApiService INSTANCE;

    private PokemonModule() {

    }

    public static PokeApiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = PokemonClient.getInstance(Const.BASE_URL).create(PokeApiService.class);
        }
        return INSTANCE;
    }
}
