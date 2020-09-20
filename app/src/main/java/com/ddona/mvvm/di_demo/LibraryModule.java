package com.ddona.mvvm.di_demo;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ApplicationComponent;

//. Constructor injection is also not possible if you don't own the class because it comes
// from an external library (classes like Retrofit, OkHttpClient, or Room databases),
// or if instances must be created with the builder pattern.
@Module
@InstallIn(ApplicationComponent.class)
public class LibraryModule {

    @Singleton
    @Provides
    public static SomeLibrary provideLibrary() {
        return new SomeLibrary("android");
    }
}
