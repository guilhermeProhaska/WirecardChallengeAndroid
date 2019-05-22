package com.guilhermeprohaska.wirecardchallengeandroid.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostResponse {

    @SerializedName("accessToken")
    @Expose
    private String accessToken;

    @SerializedName("refreshToken")
    @Expose
    private String refreshToken;

    @SerializedName("scope")
    @Expose
    private String scope;

    @SerializedName("expires_in")
    @Expose
    private String expires_in;

    @SerializedName("moipAccount")
    @Expose
    private MoipAccount moipAccount;

    public PostResponse(String accessToken, String refreshToken, String scope, String expires_in) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.scope = scope;
        this.expires_in = expires_in;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public MoipAccount getMoipAccount() {
        return moipAccount;
    }

    public static class MoipAccount {

        @SerializedName("ID")
        @Expose
        private String id;

        public MoipAccount(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}
