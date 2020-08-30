package com.ddona.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ddona.mvvm.R;
import com.ddona.mvvm.db.PokemonDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}