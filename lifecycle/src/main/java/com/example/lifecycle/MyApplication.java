package com.example.lifecycle;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

/**
 * @author AlexisYin
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ApplicationObserver());
    }
}
