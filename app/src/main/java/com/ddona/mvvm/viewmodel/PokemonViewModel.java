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

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
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
        repository.getPokemons()
                .subscribeOn(Schedulers.io())
                .map(new Function<PokemonResponse, ArrayList<Pokemon>>() {
                    @Override
                    public ArrayList<Pokemon> apply(PokemonResponse pokemonResponse) throws Throwable {
                        ArrayList<Pokemon> list = pokemonResponse.getResults();
                        for (Pokemon pokemon : list) {
                            String url = pokemon.getUrl();
                            String[] pokemonIndex = url.split("/");
                            pokemon.setUrl("https://pokeres.bastionbot.org/images/pokemon/" + pokemonIndex[pokemonIndex.length - 1] + ".png");
                        }
                        Log.e(TAG, "apply: " + list.get(2).getUrl());
                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> pokemonList.setValue(result),
                        error -> Log.e(TAG, "getPokemons: " + error.getMessage()));
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
