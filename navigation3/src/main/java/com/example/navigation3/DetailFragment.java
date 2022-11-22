package com.example.navigation3;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            String name = args.getString("name");
            if (!TextUtils.isEmpty(name)) {
                Log.d("TAG", "getArguments name: " + name);
            }
            String params = args.getString("params");
            if (!TextUtils.isEmpty(params)) {
                Log.d("TAG", "getArguments params: " + params);
            }
        }

        Button button = getView().findViewById(R.id.button2);
        button.setOnClickListener((v) -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_detailFragment_to_homeFragment);
        });
    }
}