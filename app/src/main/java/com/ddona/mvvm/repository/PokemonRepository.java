package com.ddona.mvvm.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import com.ddona.mvvm.db.PokemonDao;
import com.ddona.mvvm.db.PokemonDatabase;
import com.ddona.mvvm.model.Pokemon;
import com.ddona.mvvm.model.PokemonResponse;
import com.ddona.mvvm.network.PokeApiService;
import com.ddona.mvvm.network.PokemonModule;

import java.util.List;

import retrofit2.Call;

public class PokemonRepository {
    private PokemonDao pokemonDao;
    private PokeApiService pokeApiService;


    public PokemonRepository(Application application) {
        this.pokemonDao = PokemonDatabase.getPokemonDatabase(application).pokemonDao();
        this.pokeApiService = PokemonModule.getInstance();
    }

    public Call<PokemonResponse> getPokemons() {
        return pokeApiService.getPokemons();
    }

    public void insertPokemon(Pokemon pokemon) {
        pokemonDao.insertPokemon(pokemon);
    }

    public void deletePokemon(String pokemonName) {
        pokemonDao.deletePokemon(pokemonName);
    }

    public void deleteAll() {
        pokemonDao.deleteAll();
    }

    public LiveData<List<Pokemon>> getFavoritePokemon() {
        return pokemonDao.getFavoritePokemons();
    }

}
