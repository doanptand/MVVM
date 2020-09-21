package com.ddona.mvvm.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.ddona.mvvm.R;
import com.ddona.mvvm.callback.HandleClick;
import com.ddona.mvvm.databinding.ActivityProfileBinding;
import com.ddona.mvvm.model.User;
import com.ddona.mvvm.viewmodel.ProfileViewModel;

import java.util.Random;

public class ProfileActivity extends AppCompatActivity implements HandleClick {
    private ActivityProfileBinding binding;
    private ProfileViewModel viewModel;
    private Random random;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        binding.setUser(new User("Temp", "Temp", R.mipmap.ic_launcher));
        binding.setOnClick(this);
        random = new Random();
//        binding.btnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                binding.setUser(new User("Doan" + new Random().nextInt(), "doanptand@gmail.com", R.drawable.pokemon));
//            }
//        });
    }

    @Override
    public void onClick() {
        binding.setUser(new User("User:" + random.nextInt(), "doanptand@gmail.com", R.drawable.pokemon));
    }
}
