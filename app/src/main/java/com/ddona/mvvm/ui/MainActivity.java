package com.ddona.mvvm.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import com.ddona.mvvm.R;
import com.ddona.mvvm.adapter.PokemonPagerAdapter;
import com.ddona.mvvm.databinding.ActivityMainBinding;
import com.ddona.mvvm.di_demo.Car;
import com.google.android.material.navigation.NavigationView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding binding;
    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
        car = new Car();
        car.drive();
    }

    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        binding.vpPokemon.setAdapter(new PokemonPagerAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.vpPokemon);
        binding.navMain.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (!binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.openDrawer(GravityCompat.START);
            } else {
                binding.drawer.close();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_list:
                binding.vpPokemon.setCurrentItem(0);
                break;
            case R.id.item_favorite:
                binding.vpPokemon.setCurrentItem(1);
                break;
            case R.id.item_about:
                Toast.makeText(this, "In develop process", Toast.LENGTH_SHORT).show();
                break;
        }
        binding.drawer.close();
        return false;
    }
}