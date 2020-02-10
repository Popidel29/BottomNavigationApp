package com.example.bottomnavigationapp.presenter;

import com.example.bottomnavigationapp.model.CommentsModel;
import com.example.bottomnavigationapp.model.PostsModel;

import java.util.List;

public interface PostsContract {

    interface ViewInterface<T>{
        void display(List<T> Model);
        void displayProgressBar();
        void stopProgressBar();
        void showError(String error);
    }

    interface PresenterInterface{
        void onDestroy();
        void onStart();

    }
    interface OnFinisherListener<T> {
        void success(List<T> Model);

        void failure(String error);
    }

}
