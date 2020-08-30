package com.ddona.mvvm.viewmodel;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class PokemonViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;


    public PokemonViewModelFactory(Application application) {
        mApplication = application;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new PokemonViewModel(mApplication);
    }
}
