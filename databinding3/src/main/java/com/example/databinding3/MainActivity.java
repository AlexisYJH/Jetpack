package com.example.databinding3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.databinding3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202106%2F28%2F20210628011842_f20bd.thumb.1000_0.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671516464&t=a21c4e79b25bc8aea9e9bed7959a9d75";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //加载网络图片
        activityMainBinding.setNetImage(URL);
        //加载本地图片
        //activityMainBinding.setLocalImage(R.drawable.lilwen);
    }
}