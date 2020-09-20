package com.ddona.mvvm.di_demo;

import android.util.Log;

//This is libary. We can't add @Inject here
public class SomeLibrary {

    String libraryName;

    public SomeLibrary(String libraryName) {
        this.libraryName = libraryName;
    }

    public void doSomeAwesome() {
        Log.d("doanpt", "library do something");
    }
}
