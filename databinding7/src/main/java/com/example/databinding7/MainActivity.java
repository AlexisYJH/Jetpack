package com.example.databinding7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.databinding7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(
                new ViewModelProvider(this,
                        new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class));
        activityMainBinding.setLifecycleOwner(this);
    }
}