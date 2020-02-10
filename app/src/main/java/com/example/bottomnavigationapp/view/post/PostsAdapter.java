package com.example.bottomnavigationapp.view.post;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationapp.R;
import com.example.bottomnavigationapp.model.PostsModel;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.myViewHolder> {
    private List<PostsModel> models;

    public PostsAdapter(List<PostsModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.title.setText(models.get(position).getTitle());
        holder.bodyText.setText(models.get(position).getBody());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView bodyText;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.posts_title);
            bodyText = itemView.findViewById(R.id.posts_body);
        }
    }
}
