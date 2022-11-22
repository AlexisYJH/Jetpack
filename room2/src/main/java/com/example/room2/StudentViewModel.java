package com.example.room2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * @author AlexisYin
 */
public class StudentViewModel extends AndroidViewModel {
    private StudentRepository studentRepository;


    public StudentViewModel(@NonNull Application application) {
        super(application);
        this.studentRepository = new StudentRepository(application);
    }

    public void insert(Student... students) {
        studentRepository.insert(students);
    }

    public void update(Student... students) {
        studentRepository.update(students);
    }

    public void delete(Student... students) {
        studentRepository.delete(students);
    }

    public void clear() {
        studentRepository.clear();
    }

    public LiveData<List<Student>> getAllStudentsLive() {
        return studentRepository.getAllStudentsLive();
    }
}
