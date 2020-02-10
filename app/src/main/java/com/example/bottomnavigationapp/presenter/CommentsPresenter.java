package com.example.bottomnavigationapp.presenter;

import com.example.bottomnavigationapp.model.CommentsModel;
import com.example.bottomnavigationapp.network.RetrofitCall;

import java.util.List;

public class CommentsPresenter implements PostsContract.PresenterInterface, PostsContract.OnFinisherListener<CommentsModel> {
    private PostsContract.ViewInterface viewInterface;
    private RetrofitCall retrofitCall;

    public CommentsPresenter(PostsContract.ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void onStart() {
        viewInterface.displayProgressBar();
        retrofitCall = new RetrofitCall(this);
        retrofitCall.getComments(1);
    }

    @Override
    public void onDestroy() {
        viewInterface = null;
    }

    @Override
    public void success(List<CommentsModel> commentsModel) {
        viewInterface.stopProgressBar();
        viewInterface.display(commentsModel);
    }

    @Override
    public void failure(String error) {
        viewInterface.showError(error);
    }

}

