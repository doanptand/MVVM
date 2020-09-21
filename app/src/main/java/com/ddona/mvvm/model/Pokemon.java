package com.ddona.mvvm.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;

/**
 * Created by ddona on 30,Aug,2020
 */
@Entity(tableName = "favorite_table")
public class Pokemon {

    @PrimaryKey(autoGenerate = true)
    int id;
    String name;

    String url;

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @BindingAdapter("setPokemonRes")
    public static void setImageResource(ImageView imageView, String url) {
        Glide.with(imageView).load(url).centerCrop().into(imageView);
    }
}