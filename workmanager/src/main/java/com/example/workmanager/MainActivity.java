package com.example.workmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addWork(View view) {
        Constraints constraints = new Constraints.Builder()
                .setRequiresBatteryNotLow(true)
                //.setRequiresCharging(true)
                //.setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        Data inputData = new Data.Builder()
                .putString("input_data", "LIL WEN")
                .build();
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWork.class)
                .setConstraints(constraints)
                //设置延迟执行
                //.setInitialDelay(2, TimeUnit.SECONDS)
                //指数退避策略，对应Result.retry()
                //.setBackoffCriteria(BackoffPolicy.LINEAR, Duration.ofSeconds(2))
                //设置tag标签
                .addTag("request")
                //参数传递
                .setInputData(inputData)
                .build();
        WorkManager workManager = WorkManager.getInstance(this);
        workManager.enqueue(request);

        //周期性任务
        //不能少于15min
        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWork.class, Duration.ofMinutes(15)).build();

        //观察任务状态
        workManager.getWorkInfoByIdLiveData(request.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                Log.d("TAG", "onChanged: " + workInfo.toString());
                if (workInfo != null && workInfo.getState() == WorkInfo.State.SUCCEEDED) {
                    String outputData = workInfo.getOutputData().getString("output_data");
                    if (!TextUtils.isEmpty(outputData)) {
                        Log.d("TAG", "onChanged getOutputData: " + outputData);
                    }
                }
            }
        });

        //取消任务
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                workManager.cancelWorkById(request.getId());
            }
        }, 2000);


    }
}