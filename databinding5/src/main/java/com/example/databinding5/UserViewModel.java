package com.example.databinding5;

import android.text.TextUtils;
import android.util.Log;

import androidx.databinding.ObservableField;

/**
 * @author AlexisYin
 */
public class UserViewModel {
    private ObservableField<User> userObservableField;

    public UserViewModel() {
        User user = new User("Lil Wen");
        userObservableField = new ObservableField<>();
        userObservableField.set(user);
    }

    public String getUserName() {
        return userObservableField.get().name;
    }

    public void setUserName(String name) {
        if (!TextUtils.isEmpty(name)) {
            userObservableField.get().name = name;
            Log.d("TAG", "setUserName: " + name);
        }
    }
}
