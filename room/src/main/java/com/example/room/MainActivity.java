package com.example.room;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StudentRecycleViewAdapter adapter;
    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Student> students = new ArrayList<>();
        adapter = new StudentRecycleViewAdapter(students);
        recyclerView.setAdapter(adapter);

        MyDatabase database = MyDatabase.getInstance(this);
        studentDao = database.getStudentDao();
    }


    public void insert(View view) {
        Student student = new Student("LIL WEN", 17);
        Student student1 = new Student("SONG", 18);
        new InsertTask(studentDao).execute(student, student1);
    }

    public void update(View view) {
        Student student = new Student(1, "MA", 20);//根据id更新
        new UpdateTask(studentDao).execute(student);

    }

    public void delete(View view) {
        Student student = new Student(2);//根据id删除
        new DeleteTask(studentDao).execute(student);
    }

    public void query(View view) {
        new GetAllStudentsTask(studentDao).execute();
    }

    class InsertTask extends AsyncTask<Student, Void, Void> {
        private StudentDao studentDao;

        public InsertTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.insert(students);
            return null;
        }
    }

    class UpdateTask extends AsyncTask<Student, Void, Void> {
        private StudentDao studentDao;

        public UpdateTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.update(students);
            return null;
        }
    }

    class DeleteTask extends AsyncTask<Student, Void, Void> {
        private StudentDao studentDao;

        public DeleteTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.delete(students);
            return null;
        }
    }

    class GetAllStudentsTask extends AsyncTask<Void, Void, Void> {
        private StudentDao studentDao;

        public GetAllStudentsTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            adapter.setStudents(studentDao.getAllStudents());
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            adapter.notifyDataSetChanged();
        }
    }
}