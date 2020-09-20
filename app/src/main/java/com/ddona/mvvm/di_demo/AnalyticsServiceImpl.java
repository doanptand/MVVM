package com.ddona.mvvm.di_demo;

import android.util.Log;

import javax.inject.Inject;

public class AnalyticsServiceImpl implements AnalyticsService {

    @Inject
    public AnalyticsServiceImpl() {

    }

    @Override
    public void analyticsMethods() {
        Log.d("doanpt", "This is implement of AnalyticsService");
    }
}
