package com.ddona.mvvm.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ddona.mvvm.model.Pokemon;

import java.util.List;

@Dao
public interface PokemonDao {

    @Insert
    void insertPokemon(Pokemon pokemon);

    @Query("DELETE FROM favorite_table WHERE name = :pokemonName")
    void deletePokemon(String pokemonName);

    @Query("DELETE FROM favorite_table")
    void deleteAll();

    @Query("SELECT * FROM favorite_table")
    LiveData<List<Pokemon>> getFavoritePokemons();
}
