package com.example.paging.paging;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paging.R;
import com.example.paging.model.Movie;
import com.squareup.picasso.Picasso;

/**
 * @author AlexisYin
 */
public class MoviePagedListAdapter extends PagedListAdapter<Movie, MoviePagedListAdapter.MovieVewHolder> {

    //差分，只更新需要更新的元素，而不是整个刷新数据源
    private static DiffUtil.ItemCallback<Movie> callback = new DiffUtil.ItemCallback<Movie>() {
        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.equals(newItem);
        }
    };

    public MoviePagedListAdapter() {
        super(callback);
    }

    @NonNull
    @Override
    public MovieVewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MovieVewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieVewHolder holder, int position) {
        Movie movie = getItem(position);
        if(movie != null) {
            Picasso.get().load(movie.cover)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(holder.imageView);
            if (movie.title.length() >= 8) {
                movie.title = movie.title.substring(0, 7);
            }
            holder.textViewTitle.setText(movie.title);
            holder.textViewRate.setText(movie.rate);
        }
    }

    class MovieVewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        TextView textViewTitle, textViewRate;

        public MovieVewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewRate = itemView.findViewById(R.id.textViewRate);
        }
    }

}
