package com.example.room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @author AlexisYin
 */
public class StudentRecycleViewAdapter extends RecyclerView.Adapter<StudentRecycleViewAdapter.ViewHolder> {

    private List<Student> students;

    public StudentRecycleViewAdapter(List<Student> students) {
        this.students = students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = students.get(position);
        Log.d("TAG", "onBindViewHolder: " + student.toString());
        TextView tvId = holder.itemView.findViewById(R.id.tvId);
        tvId.setText(String.valueOf(student.id));
        TextView tvName = holder.itemView.findViewById(R.id.tvName);
        tvName.setText(student.name);
        TextView tvAge = holder.itemView.findViewById(R.id.tvAge);
        tvAge.setText(String.valueOf(student.age));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
