package com.ddona.mvvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ddona.mvvm.R;
import com.ddona.mvvm.databinding.ItemPokemonBinding;
import com.ddona.mvvm.model.Pokemon;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {
    private List<Pokemon> mPokemons;

    public PokemonAdapter(List<Pokemon> mPokemons) {
        this.mPokemons = mPokemons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPokemonBinding binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvName.setText(mPokemons.get(position).getName());
        Glide.with(holder.binding.imgAvatar).load(mPokemons.get(position).getUrl())
                .into(holder.binding.imgAvatar);
    }

    public Pokemon getPokemonAt(int position) {
        return mPokemons.get(position);
    }

    @Override
    public int getItemCount() {
        return mPokemons == null ? 0 : mPokemons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemPokemonBinding binding;

        public ViewHolder(ItemPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
