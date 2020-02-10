package com.example.bottomnavigationapp.view.comments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationapp.R;
import com.example.bottomnavigationapp.model.CommentsModel;


import java.util.List;

public class CommentAdpter extends RecyclerView.Adapter<CommentAdpter.myViewHolder> {
    private List<CommentsModel> models;

    public CommentAdpter(List<CommentsModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public CommentAdpter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_item, parent, false);
        return new CommentAdpter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdpter.myViewHolder holder, int position) {
        holder.name.setText(models.get(position).getName());
        holder.body.setText(models.get(position).getBody());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView body;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.comment_name);
            body = itemView.findViewById(R.id.comment_body);
        }
    }
}
