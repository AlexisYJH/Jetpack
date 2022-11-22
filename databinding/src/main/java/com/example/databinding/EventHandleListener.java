package com.example.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * @author AlexisYin
 */
public class EventHandleListener {
    private Context context;

    public EventHandleListener(Context context) {
        this.context = context;
    }

    public void buttonOnClick(View view) {
        Toast.makeText(context, "超喜欢", Toast.LENGTH_SHORT).show();
    }
}
