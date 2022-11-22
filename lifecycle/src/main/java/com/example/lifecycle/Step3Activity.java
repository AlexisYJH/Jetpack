package com.example.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Step3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void start(View view) {
        startService(new Intent(this, MyLocationService.class));
    }

    public void stop(View view) {
        stopService(new Intent(this, MyLocationService.class));
    }
}