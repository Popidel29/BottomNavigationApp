package com.example.bottomnavigationapp.view.comments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationapp.R;
import com.example.bottomnavigationapp.model.CommentsModel;
import com.example.bottomnavigationapp.model.PostsModel;
import com.example.bottomnavigationapp.presenter.CommentsPresenter;
import com.example.bottomnavigationapp.presenter.PostsContract;
import com.example.bottomnavigationapp.presenter.PostsPresenter;
import com.example.bottomnavigationapp.view.post.PostsAdapter;

import java.util.List;

public class CommentsFragment extends Fragment implements PostsContract.ViewInterface<CommentsModel> {
    private RecyclerView recyclerView;
    private LinearLayout linearLayout;
    private ProgressBar progressBar;
    private CommentAdpter commentAdpter;
    private Button btnRetry;
    PostsContract.PresenterInterface presenterInterface;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.comment_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        linearLayout = view.findViewById(R.id.linear_layout);
        progressBar = view.findViewById(R.id.progress_bar);
        btnRetry = view.findViewById(R.id.btn_retry);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterInterface.onStart();
            }
        });
        presenterInterface = new CommentsPresenter(this);
        presenterInterface.onStart();
    }

    @Override
    public void display(List<CommentsModel> commentsList) {

        commentAdpter = new CommentAdpter(commentsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(commentAdpter);
        linearLayout.setVisibility(View.VISIBLE);
        btnRetry.setVisibility(View.GONE);
    }

    @Override
    public void displayProgressBar() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void stopProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        linearLayout.setVisibility(View.VISIBLE);
        btnRetry.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();


    }
}
