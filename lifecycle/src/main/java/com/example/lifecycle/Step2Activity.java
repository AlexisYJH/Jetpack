package com.example.lifecycle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Step2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyChronometer chronometer = findViewById(R.id.mychronometer);
        getLifecycle().addObserver(chronometer);
    }
}