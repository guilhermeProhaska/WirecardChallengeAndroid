package com.guilhermeprohaska.wirecardchallengeandroid.entities;

import com.google.gson.annotations.SerializedName;

public class Orders {

    @SerializedName("ownId")
    private String ownId;

    @SerializedName("customer")
    private String customer;

    @SerializedName("status")
    private String status;

    @SerializedName("updateAt")
    private String updateAt;

    @SerializedName("amount")
    private String amount;

    public Orders(String ownId, String customer, String status, String updateAt, String amount) {
        this.ownId = ownId;
        this.customer = customer;
        this.status = status;
        this.updateAt = updateAt;
        this.amount = amount;
    }

    public String getOwnId() {
        return ownId;
    }

    public String getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public String getAmount() {
        return amount;
    }
}
