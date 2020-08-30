package com.ddona.mvvm.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddona.mvvm.model.Pokemon;
import com.ddona.mvvm.model.PokemonResponse;
import com.ddona.mvvm.repository.PokemonRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonViewModel extends ViewModel {

    private static final String TAG = "PokemonViewModel";

    private PokemonRepository repository;
    private MutableLiveData<ArrayList<Pokemon>> pokemonList = new MutableLiveData<>();
    private LiveData<List<Pokemon>> favoritePokemonList = null;

    public PokemonViewModel(Application application) {
        this.repository = new PokemonRepository(application);
        favoritePokemonList = repository.getFavoritePokemon();
    }

    public MutableLiveData<ArrayList<Pokemon>> getPokemonList() {
        return pokemonList;
    }

    public void getPokemons() {
        repository.getPokemons().enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    ArrayList<com.ddona.mvvm.model.Pokemon> list = response.body().getResults();
                    for (Pokemon pokemon : list) {
                        String url = pokemon.getUrl();
                        String[] pokemonIndex = url.split("/");
                        pokemon.setUrl("https://pokeres.bastionbot.org/images/pokemon/" + pokemonIndex[pokemonIndex.length - 1] + ".png");
                    }
                    pokemonList.postValue(list);
                    Log.e(TAG, "apply: " + list.get(2).getUrl());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                pokemonList.postValue(null);
            }
        });
    }

    public void insertPokemon(Pokemon pokemon) {
        repository.insertPokemon(pokemon);
    }

    public void deletePokemon(String pokemonName) {
        repository.deletePokemon(pokemonName);
    }

    public LiveData<List<Pokemon>> getFavoritePokemonList() {
        return favoritePokemonList;
    }

    public void getFavoritePokemon() {
        favoritePokemonList = repository.getFavoritePokemon();
    }

}
