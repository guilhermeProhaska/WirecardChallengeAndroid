package com.guilhermeprohaska.wirecardchallengeandroid.service;

import com.guilhermeprohaska.wirecardchallengeandroid.entities.PostResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserClient {

    @Headers("Authorization: OAuth ACCESS_TOKEN")
    @FormUrlEncoded
    @POST("token")
    Call<PostResponse> postRequest(
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret,
            @Field("scope") String scope,
            @Field("grant_type") String grant_type,
            @Field("device_id") String device_id,
            @Field("username") String username,
            @Field("password") String password
    );
}
