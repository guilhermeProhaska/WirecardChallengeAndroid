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

    public static class Orders {

        @SerializedName("ownId")
        private String ownId;

        @SerializedName("customer")
        private Customer customer;

        @SerializedName("status")
        private String status;

        @SerializedName("updateAt")
        private String updateAt;

        @SerializedName("amount")
        private Amount amount;

        public Orders(String ownId, Customer customer, String status, String updateAt, Amount amount) {
            this.ownId = ownId;
            this.customer = customer;
            this.status = status;
            this.updateAt = updateAt;
            this.amount = amount;
        }

        public String getOwnId() {
            return ownId;
        }

        public Customer getCustomer() {
            return customer;
        }

        public String getStatus() {
            return status;
        }

        public String getUpdateAt() {
            return updateAt;
        }

        public Amount getAmount() {
            return amount;
        }

        public static class Customer {

            @SerializedName("fullname")
            private String fullname;

            @SerializedName("email")
            private String email;

            public Customer(String fullname, String email) {
                this.fullname = fullname;
                this.email = email;
            }

            public String getFullname() {
                return fullname;
            }

            public String getEmail() {
                return email;
            }
        }

        public static class Amount {

            @SerializedName("total")
            private String total;

            public Amount(String total) {
                this.total = total;
            }

            public String getTotal() {
                return total;
            }
        }
    }
}
