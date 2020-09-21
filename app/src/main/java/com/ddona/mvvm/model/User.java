package com.ddona.mvvm.model;

public class User {
    private String name;
    private String email;
    private int avatar;

    public User(String name, String email, int avatar) {
        this.name = name;
        this.email = email;
        this.avatar = avatar;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
