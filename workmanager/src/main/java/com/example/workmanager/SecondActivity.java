package com.example.workmanager;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AlexisYin
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addWork(View view) {
        OneTimeWorkRequest a = new OneTimeWorkRequest.Builder(AWorker.class).build();
        OneTimeWorkRequest b = new OneTimeWorkRequest.Builder(BWorker.class).build();
        OneTimeWorkRequest c = new OneTimeWorkRequest.Builder(CWorker.class).build();
        OneTimeWorkRequest d = new OneTimeWorkRequest.Builder(DWorker.class).build();
        OneTimeWorkRequest e = new OneTimeWorkRequest.Builder(EWorker.class).build();

        //WorkManager.getInstance(this).beginWith(a).then(b).enqueue();

        WorkContinuation workContinuation1 = WorkManager.getInstance(this)
                .beginWith(a).then(b);
        WorkContinuation workContinuation2 = WorkManager.getInstance(this)
                .beginWith(c).then(d);
        List<WorkContinuation> list = new ArrayList<>();
        list.add(workContinuation1);
        list.add(workContinuation2);
        WorkContinuation.combine(list).then(e).enqueue();
    }
}
