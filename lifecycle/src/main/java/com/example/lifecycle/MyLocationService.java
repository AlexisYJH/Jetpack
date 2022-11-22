package com.example.lifecycle;

import android.util.Log;

import androidx.lifecycle.LifecycleService;

/**
 * @author AlexisYin
 */
//先添加依赖androidx.lifecycle:lifecycle-extensions
public class MyLocationService extends LifecycleService {
    public MyLocationService() {
        Log.d("TAG", "MyLocationService");
        MyLocationObserver observer = new MyLocationObserver(this);
        getLifecycle().addObserver(observer);
    }
}
