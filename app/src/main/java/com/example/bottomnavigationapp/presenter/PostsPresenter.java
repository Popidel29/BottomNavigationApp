package com.example.bottomnavigationapp.presenter;

import com.example.bottomnavigationapp.model.PostsModel;
import com.example.bottomnavigationapp.network.RetrofitCall;

import java.util.List;

public class PostsPresenter implements PostsContract.PresenterInterface, PostsContract.OnFinisherListener<PostsModel>
{
private PostsContract.ViewInterface viewInterface;
private RetrofitCall retrofitCall;

    public PostsPresenter(PostsContract.ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void onStart() {
        viewInterface.displayProgressBar();
        retrofitCall = new RetrofitCall(this);
        retrofitCall.getPosts();
    }

    @Override
    public void onDestroy() {
    viewInterface = null;
    }

    @Override
    public void success(List<PostsModel> postsModel) {
        viewInterface.stopProgressBar();
        viewInterface.display(postsModel);



    }

    @Override
    public void failure(String error) {
        viewInterface.showError(error);
    }

}
