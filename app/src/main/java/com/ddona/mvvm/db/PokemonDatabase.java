package com.ddona.mvvm.db;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Pokemon.class}, version = 1, exportSchema = false)
public abstract class PokemonDatabase extends RoomDatabase {

    public abstract PokemonDao pokemonDao();

    public static PokemonDatabase getPokemonDatabase(Application application) {
        return Room.databaseBuilder(application, PokemonDatabase.class, "PokemonDatabase")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()//This only for test. remove it on production
                .build();
    }

}
