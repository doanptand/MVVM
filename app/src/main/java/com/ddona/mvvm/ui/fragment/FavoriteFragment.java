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

public class FavoriteFragment extends Fragment {

    private static FavoriteFragment INSTANCE;

    public static FavoriteFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FavoriteFragment();
        }
        return INSTANCE;
    }

    private PokemonViewModel viewModel;
    private List<Pokemon> mFavorites;
    private PokemonAdapter adapter;
    private RecyclerView rvFavorite;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon, container, false);
        mFavorites = new ArrayList<>();
        adapter = new PokemonAdapter(mFavorites);
        rvFavorite = view.findViewById(R.id.rv_pokemon);
        rvFavorite.setAdapter(adapter);
        Log.d("doanpt", "new favorite");
        viewModel = new ViewModelProvider(requireActivity()).get(PokemonViewModel.class);
        viewModel.getFavoritePokemonList().observe(getViewLifecycleOwner(), pokemons -> {
            mFavorites.clear();
            mFavorites.addAll(pokemons);
            adapter.notifyDataSetChanged();
            Log.d("doanpt", "favorite changed");
        });
        return view;
    }
}
