package com.guilhermeprohaska.wirecardchallengeandroid.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitOrder {

    private static final String API_GET_URL = "https://sandbox.moip.com.br/v2/";
    private static RetrofitOrder mInstance;
    private Retrofit retrofit;

    private RetrofitOrder(){
        retrofit = new Retrofit.Builder()
                .baseUrl(API_GET_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitOrder getInstance(){
        if(mInstance == null){
            mInstance = new RetrofitOrder();
        }
        return mInstance;
    }

    public UserClient getOrderRetrofit(){
        return retrofit.create(UserClient.class);
    }
}
