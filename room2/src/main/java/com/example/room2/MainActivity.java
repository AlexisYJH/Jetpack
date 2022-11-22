package com.example.room2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room2.MyDatabase;
import com.example.room2.R;
import com.example.room2.Student;
import com.example.room2.StudentDao;
import com.example.room2.StudentRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StudentRecycleViewAdapter adapter;
    private StudentDao studentDao;
    private StudentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Student> students = new ArrayList<>();
        adapter = new StudentRecycleViewAdapter(students);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(StudentViewModel.class);
        viewModel.getAllStudentsLive().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                adapter.setStudents(students);
                adapter.notifyDataSetChanged();
            }
        });

    }

    public void insert(View view) {
        Student s = new Student("LIL WEN", 17);
        Student s1 = new Student("SONG", 18);
        viewModel.insert(s, s1);
    }

    public void update(View view) {
        Student s = new Student(1,"MA", 20);
        viewModel.update(s);
    }

    public void delete(View view) {
        Student s = new Student(1);
        viewModel.delete(s);
    }

    public void clear(View view) {
        viewModel.clear();
    }
}