package com.guilhermeprohaska.wirecardchallengeandroid.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String API_POST_URL ="https://connect-sandbox.moip.com.br/oauth/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(API_POST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if(mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public UserClient getClientRetrofit(){
        return retrofit.create(UserClient.class);
    }
}
