package com.example.bottomnavigationapp.network;

import android.util.Log;

import com.example.bottomnavigationapp.model.CommentsModel;
import com.example.bottomnavigationapp.model.PostsModel;
import com.example.bottomnavigationapp.presenter.PostsContract;
import com.example.bottomnavigationapp.presenter.PostsPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCall {
    private List<PostsModel> posts;
    private PostsContract.OnFinisherListener presenter;
    private static final String TAG = "RetrofitCall";

    public RetrofitCall(PostsContract.OnFinisherListener presenter) {
        this.presenter = presenter;
    }

    public void getPosts(){
        PostClient client = RetrofitInstance.getPostClient();

        Call<List<PostsModel>> call = client.getPosts();
        call.enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                if(response.body() != null){
                    presenter.success(response.body());
                }
                else{
                    presenter.failure("No Posts Available");
                }

            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {
                    presenter.failure(t.getMessage());
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });
   }

    public void getComments(Integer postId){
        PostClient client = RetrofitInstance.getPostClient();

        Call<List<CommentsModel>> call = client.getComments(postId);
        call.enqueue(new Callback<List<CommentsModel>>() {
            @Override
            public void onResponse(Call<List<CommentsModel>> call, Response<List<CommentsModel>> response) {
                if(response.body() != null){
                    presenter.success(response.body());
                }
                else{
                    presenter.failure("No Comments Available");
                }

            }

            @Override
            public void onFailure(Call<List<CommentsModel>> call, Throwable t) {
                presenter.failure(t.getMessage());
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}