package com.example.workmanager;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * @author AlexisYin
 */
public class MyWork extends Worker {
    public MyWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        //SystemClock.sleep(2000);
        Log.d("TAG", "doWork: MyWork");
        String data = getInputData().getString("input_data");
        if (!TextUtils.isEmpty(data)) {
            Log.d("TAG", "doWork getInputData: " + data);
        }
        Data outputData = new Data.Builder()
                .putString("output_data", "执行成功")
                .build();

        return Result.success(outputData);
    }
}
