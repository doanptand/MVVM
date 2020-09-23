package com.ddona.mvvm.adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.ddona.mvvm.model.Pokemon;

import java.util.List;

public class PokeMonDiffCallback extends DiffUtil.Callback {
    private final List<Pokemon> mOldPokemonList;
    private final List<Pokemon> mNewPokemonList;

    public PokeMonDiffCallback(List<Pokemon> oldList, List<Pokemon> newList) {
        this.mOldPokemonList = oldList;
        this.mNewPokemonList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldPokemonList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewPokemonList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldPokemonList.get(oldItemPosition).getId() == mNewPokemonList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldPokemonList.get(oldItemPosition).equals(mNewPokemonList.get(newItemPosition));
    }
}
