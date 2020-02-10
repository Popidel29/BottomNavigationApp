package com.example.bottomnavigationapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit;
    private static PostClient postClient;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

    public static PostClient getPostClient(){
        if (postClient == null) {
            postClient = getRetrofitInstance().create(PostClient.class);
        }
    return postClient;
    }
}
