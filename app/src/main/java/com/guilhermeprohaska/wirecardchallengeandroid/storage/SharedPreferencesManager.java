package com.guilhermeprohaska.wirecardchallengeandroid.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.guilhermeprohaska.wirecardchallengeandroid.entities.PostResponse;
import com.guilhermeprohaska.wirecardchallengeandroid.entities.User;

public class SharedPreferencesManager {

    private static final String SHARED_LOGIN = "shared_login";
    private static final String SHARED_ACCESS_TOKEN = "shared_access_token";

    private static SharedPreferencesManager mInstance;
    private Context mCtx;

    public SharedPreferencesManager(Context mCtx) {
        this.mCtx = mCtx;
    }

    public static synchronized SharedPreferencesManager getInstance(Context mCtx){
        if(mInstance == null){
            mInstance = new SharedPreferencesManager(mCtx);
        }
        return mInstance;
    }

    public void saveUser(User user){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_LOGIN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username", user.getUsername());
        editor.putString("password", user.getPassword());

        editor.apply();
    }

    public User getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_LOGIN, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString("username", null),
                sharedPreferences.getString("password", null)
        );
    }

    public void savePostResponse(PostResponse postResponse){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_ACCESS_TOKEN,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("access_token",postResponse.getAccessToken());
        editor.putString("refresh_token", postResponse.getRefreshToken());
        editor.putString("scope", postResponse.getScope());
        editor.putString("expires_in", postResponse.getExpires_in());
        editor.putString("moip_account", postResponse.getMoipAccount().getId());

        editor.apply();
    }

    public PostResponse getPostResponse(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_ACCESS_TOKEN,Context.MODE_PRIVATE);
        return new PostResponse(
                sharedPreferences.getString("access_token", null),
                sharedPreferences.getString("refresh_token", null),
                sharedPreferences.getString("scope", null),
                sharedPreferences.getString("expires_in", null)
        );
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_LOGIN,Context.MODE_PRIVATE);
        return sharedPreferences.getString("username", null) != null;
    }
    public void clearUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_LOGIN,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public void clearToken(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_ACCESS_TOKEN,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
