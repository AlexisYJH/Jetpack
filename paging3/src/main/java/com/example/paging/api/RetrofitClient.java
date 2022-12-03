package com.example.paging.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author AlexisYin
 */
public class RetrofitClient {
    /**
     * private static final String BASE_URL = "http://localhost:8080/pagingserver/";
     * Failed to connect to /127.0.0.1:8080（使用retrofit2的时候出现的问题）
     * 原因是如果用localhost或者127.0.0.1访问，肯定就是访问到模拟器里了，而不是你的电脑上。
     * 运行——打开cmd——输入ipconfig查看ipv4协议
     * 把地址换成ipv4就可以了，也就是把localhost换成192.168.0.104
     */
    private static final String BASE_URL = "http://192.168.0.104:8080/pagingserver/";

    private static RetrofitClient sInstance;
    private Retrofit retrofit;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
    }

    private OkHttpClient getClient() {
        return new OkHttpClient.Builder().build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (sInstance == null) {
            sInstance = new RetrofitClient();
        }
        return sInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}
