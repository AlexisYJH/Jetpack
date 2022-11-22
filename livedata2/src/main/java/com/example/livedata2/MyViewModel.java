package com.example.livedata2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author AlexisYin
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> progress;

    public MutableLiveData<Integer> getProgress() {
        if (progress == null) {
            progress = new MutableLiveData<>();
            progress.setValue(0);
        }
        return progress;
    }
}
