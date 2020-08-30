package com.ddona.mvvm.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.ddona.mvvm.R;
import com.ddona.mvvm.adapter.PokemonAdapter;
import com.ddona.mvvm.model.Pokemon;
import com.ddona.mvvm.viewmodel.PokemonViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PokemonFragment extends Fragment {

    private static PokemonFragment INSTANCE;
    private PokemonViewModel viewModel;
    private List<Pokemon> mPokemons;


    public static PokemonFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PokemonFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPokemons = new ArrayList<>();
        PokemonAdapter adapter = new PokemonAdapter(mPokemons);
        viewModel = new ViewModelProvider(requireActivity()).get(PokemonViewModel.class);
        viewModel.getPokemonList().observe(getViewLifecycleOwner(), pokemons -> {
            mPokemons.clear();
            mPokemons.addAll(pokemons);
            adapter.notifyDataSetChanged();
        });
        viewModel.getPokemons();
        View view = inflater.inflate(R.layout.fragment_pokemon, container, false);
        RecyclerView rvPokemon = view.findViewById(R.id.rv_pokemon);
        rvPokemon.setAdapter(adapter);
        return view;
    }
}
