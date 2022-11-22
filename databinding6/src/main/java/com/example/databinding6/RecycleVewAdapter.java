package com.example.databinding6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databinding6.databinding.ItemBinding;

import java.util.List;

/**
 * @author AlexisYin
 */
public class RecycleVewAdapter extends RecyclerView.Adapter<RecycleVewAdapter.MyViewHolder>{
    List<Idol> idols;

    public RecycleVewAdapter(List<Idol> idols) {
        this.idols = idols;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item,
                parent,
                false);
        MyViewHolder myViewHolder = new MyViewHolder(itemBinding);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemBinding.setIdol(idols.get(position));
    }

    @Override
    public int getItemCount() {
        return idols.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        ItemBinding itemBinding;

        public MyViewHolder(ItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
