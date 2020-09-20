package com.ddona.mvvm.di_demo;

import android.telecom.Call;
import android.util.Log;

import javax.inject.Inject;

public class Car {

    Driver driver;

    @Inject
    public Car(Driver driver) {
        this.driver = driver;
    }

    public void drive() {
        Log.d("doanpt", "Car is running");
    }

    public void sayHello() {
        Log.d("doanpt", "Hello " + this.driver.getName());
    }
}
