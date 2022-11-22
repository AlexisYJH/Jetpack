package com.example.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

/**
 * @author AlexisYin
 */
//不要向ViewModel中传入Context，会导致内存泄漏
//如果要使用Context，请使用AndroidViewModel中的Application
public class MyViewModel extends ViewModel{
    public int number;
}

class TestViewModel extends AndroidViewModel{

    public TestViewModel(@NonNull Application application) {
        super(application);
    }
}