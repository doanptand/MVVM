package com.ddona.mvvm.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return id == pokemon.id &&
                name.equals(pokemon.name) &&
                url.equals(pokemon.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url);
    }
}