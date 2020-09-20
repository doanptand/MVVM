package com.ddona.mvvm.di_demo;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class AnalyticsModule {

    @Binds
    public abstract AnalyticsService bindAnalyticsService(
            AnalyticsServiceImpl analyticsServiceImpl
    );
}
