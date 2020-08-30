package com.ddona.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.ddona.mvvm.db.Pokemon;
import com.ddona.mvvm.db.PokemonDao;
import com.ddona.mvvm.model.PokemonResponse;
import com.ddona.mvvm.network.PokeApiService;

import java.util.List;

import retrofit2.Call;

public class PokemonRepository {
    private PokemonDao pokemonDao;
    private PokeApiService pokeApiService;


    public PokemonRepository(PokemonDao pokemonDao, PokeApiService pokeApiService) {
        this.pokemonDao = pokemonDao;
        this.pokeApiService = pokeApiService;
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
