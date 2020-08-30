package com.ddona.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.ddona.mvvm.R;
import com.ddona.mvvm.db.PokemonDatabase;
import com.ddona.mvvm.model.Pokemon;
import com.ddona.mvvm.viewmodel.PokemonViewModel;
import com.ddona.mvvm.viewmodel.PokemonViewModelFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PokemonViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this, new PokemonViewModelFactory(this.getApplication())).get(PokemonViewModel.class);
        viewModel.getPokemonList().observe(this, new Observer<ArrayList<Pokemon>>() {
            @Override
            public void onChanged(ArrayList<Pokemon> pokemons) {
                Log.d("doanpt", "pokemon size:" + pokemons.size());
            }
        });
    }
}