package com.ddona.mvvm.di;

import android.app.Application;

import androidx.room.Room;

import com.ddona.mvvm.db.PokemonDao;
import com.ddona.mvvm.db.PokemonDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public static PokemonDatabase providePokemonDB(Application application) {
        return Room.databaseBuilder(application, PokemonDatabase.class, "PokemonDatabase")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static PokemonDao providePokeDao(PokemonDatabase pokemonDB) {
        return pokemonDB.pokemonDao();
    }
}
