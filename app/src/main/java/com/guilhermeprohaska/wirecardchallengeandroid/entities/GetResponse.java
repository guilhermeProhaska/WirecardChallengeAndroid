package com.guilhermeprohaska.wirecardchallengeandroid.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetResponse {

    @SerializedName("orders")
    @Expose
    private List<Orders> orders;

    @SerializedName("summary")
    @Expose
    private Summary summary;

    public GetResponse(List<Orders> orders) {
        this.orders = orders;
    }

    public GetResponse(Summary summary) {
        this.summary = summary;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public Summary getSummary() {
        return summary;
    }

    static class Summary {

        @SerializedName("count")
        private int count;

        @SerializedName("amount")
        private long amount;

        public int getCount() {
            return count;
        }

        public long getAmount() {
            return amount;
        }
    }
}
