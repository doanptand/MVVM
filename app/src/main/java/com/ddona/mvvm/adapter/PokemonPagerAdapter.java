package com.ddona.mvvm.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ddona.mvvm.ui.fragment.FavoriteFragment;
import com.ddona.mvvm.ui.fragment.PokemonFragment;

public class PokemonPagerAdapter extends FragmentPagerAdapter {
    private final String[] titles = new String[]{"Pokemon", "Favorite"};

    public PokemonPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PokemonFragment.getInstance();
            case 1:
                return FavoriteFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
