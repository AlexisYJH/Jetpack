package com.example.databinding4;

import android.text.TextUtils;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author AlexisYin
 */
public class UserViewModel extends BaseObservable {
    private User user;

    public UserViewModel() {
        user = new User("Lil Wen");
    }

    @Bindable
    public String getUserName() {
        return user.name;
    }

    public void setUserName(String name) {
        if (!TextUtils.isEmpty(name)) {
            user.name = name;
            Log.d("TAG", "setUserName: " + name);
            notifyPropertyChanged(BR.userName);
        }

    }
}
