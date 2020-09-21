package com.ddona.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddona.mvvm.R;
import com.ddona.mvvm.model.User;

import java.util.Random;

public class ProfileViewModel extends ViewModel {

    MutableLiveData<User> user;

    public ProfileViewModel() {
        user = new MutableLiveData<>();
    }

    public void onDataChange() {
        user.postValue(new User("Doan" + new Random().nextInt(), "doanptand@gmail.com", R.drawable.pokemon));
    }

    public MutableLiveData<User> getUser() {
        return user;
    }
}
