package com.ddona.mvvm.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.ddona.mvvm.adapter.PokemonAdapter;
import com.ddona.mvvm.databinding.FragmentPokemonBinding;
import com.ddona.mvvm.model.Pokemon;
import com.ddona.mvvm.viewmodel.PokemonViewModel;

import java.util.ArrayList;
import java.util.List;

public class PokemonFragment extends Fragment {

    private static PokemonFragment INSTANCE;
    private PokemonViewModel viewModel;
    private List<Pokemon> mPokemons;
    private PokemonAdapter adapter;
    private FragmentPokemonBinding binding;

    public static PokemonFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PokemonFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPokemonBinding.inflate(inflater, container, false);
        mPokemons = new ArrayList<>();
        adapter = new PokemonAdapter(mPokemons);
        viewModel = new ViewModelProvider(requireActivity()).get(PokemonViewModel.class);
        viewModel.getPokemonList().observe(getViewLifecycleOwner(), pokemons -> {
            adapter.setData(pokemons);
        });
        viewModel.getPokemons();
        binding.rvPokemon.setAdapter(adapter);
        setUpItemTouchHelper();
        return binding.getRoot();
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedPokemonPosition = viewHolder.getAdapterPosition();
                Pokemon pokemon = adapter.getPokemonAt(swipedPokemonPosition);
                viewModel.insertPokemon(pokemon);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Pokemon added to favorites.", Toast.LENGTH_SHORT).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.rvPokemon);
    }
}
