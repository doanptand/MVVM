package com.ddona.mvvm.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ddona.mvvm.R;

public class FavoriteFragment extends Fragment {

    private static FavoriteFragment INSTANCE;

    public static FavoriteFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FavoriteFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon, container, false);
        return view;
    }
}
