package com.ddona.mvvm.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.ddona.mvvm.R;
import com.ddona.mvvm.adapter.PokemonPagerAdapter;
import com.ddona.mvvm.model.Pokemon;
import com.ddona.mvvm.viewmodel.PokemonViewModel;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ViewPager vpPokemon;
    private TabLayout tapPokemons;
    private NavigationView nvPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        drawerLayout = findViewById(R.id.drawer);
        vpPokemon = findViewById(R.id.vp_pokemon);
        vpPokemon.setAdapter(new PokemonPagerAdapter(getSupportFragmentManager()));
        tapPokemons = findViewById(R.id.tab_layout);
        tapPokemons.setupWithViewPager(vpPokemon);
        nvPokemon = findViewById(R.id.nav_main);
        nvPokemon.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.openDrawer(GravityCompat.START);
            } else {
                drawerLayout.close();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_list:
                vpPokemon.setCurrentItem(0);
                break;
            case R.id.item_favorite:
                vpPokemon.setCurrentItem(1);
                break;
            case R.id.item_about:
                Toast.makeText(this, "In develop process", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.close();
        return false;
    }
}