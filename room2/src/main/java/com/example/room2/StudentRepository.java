package com.example.room2;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * @author AlexisYin
 */
public class StudentRepository {

    private StudentDao studentDao;

    public StudentRepository(Context context) {
        this.studentDao = MyDatabase.getInstance(context).getStudentDao();
    }

    public void insert(Student... students) {
        new InsertTask(studentDao).execute(students);
    }

    public void update(Student... students) {
        new UpdateTask(studentDao).execute(students);
    }

    public void delete(Student... students) {
        new DeleteTask(studentDao).execute(students);
    }

    public void clear() {
        new ClearTask(studentDao).execute();
    }

    public LiveData<List<Student>> getAllStudentsLive() {
        return studentDao.getAllStudentslive();
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

    class ClearTask extends AsyncTask<Void, Void, Void> {
        private StudentDao studentDao;

        public ClearTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentDao.clear();
            return null;
        }
    }
}
