package com.ddona.mvvm.util;

import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ddona.mvvm.adapter.PokemonAdapter;
import com.ddona.mvvm.model.Pokemon;

import java.util.List;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter("image_url")
    public static void setImageResource(ImageView imageView, String url) {
        Glide.with(imageView).load(url)
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(imageView);
    }

    @androidx.databinding.BindingAdapter("image_resource")
    public static void setImageResource(ImageView imageView, int resource) {
        Glide.with(imageView).asBitmap()
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .load(resource).into(imageView);
    }

    @androidx.databinding.BindingAdapter("recyclerview:data")
    public static void setData(RecyclerView recyclerView, List<Pokemon> data) {
        if (recyclerView.getAdapter() instanceof PokemonAdapter) {
            ((PokemonAdapter) recyclerView.getAdapter()).setData(data);
        }
    }

    @androidx.databinding.BindingAdapter("recyclerview:adapter")
    public static void setAdapter(RecyclerView recyclerView, PokemonAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
