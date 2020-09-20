package com.ddona.mvvm.di_demo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Driver {
    @Inject
    public Driver() {

    }

    public String getName() {
        return "Doan";
    }
}
