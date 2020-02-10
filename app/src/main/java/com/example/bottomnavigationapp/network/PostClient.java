package com.example.bottomnavigationapp.network;

import com.example.bottomnavigationapp.model.CommentsModel;
import com.example.bottomnavigationapp.model.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostClient {
    @GET("posts")
    Call<List<PostsModel>> getPosts();

    @GET("posts/{postId}/comments")
    Call <List<CommentsModel>> getComments(@Path("postId") Integer postId);
}
