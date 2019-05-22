package com.guilhermeprohaska.wirecardchallengeandroid.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.guilhermeprohaska.wirecardchallengeandroid.R;
import com.guilhermeprohaska.wirecardchallengeandroid.adapter.OrderAdapter;
import com.guilhermeprohaska.wirecardchallengeandroid.entities.GetResponse;
import com.guilhermeprohaska.wirecardchallengeandroid.storage.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private List<GetResponse.Orders> ordersList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GetResponse.Orders.Customer customer = new GetResponse.Orders.Customer("name1", "email1@gmail.com");
    private GetResponse.Orders.Amount amount = new GetResponse.Orders.Amount("R$ 1111,11");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ordersList.add(new GetResponse.Orders(SharedPreferencesManager.getInstance(OrderActivity.this).getUser().getUsername()
                , customer, "OK1", "01/01/1111", amount));
        ordersList.add(new GetResponse.Orders(SharedPreferencesManager.getInstance(OrderActivity.this).getUser().getPassword()
                , customer, "OK2", "02/02/2222", amount));
        ordersList.add(new GetResponse.Orders(SharedPreferencesManager.getInstance(OrderActivity.this).getPostResponse().getAccessToken()
                , customer, "OK3", "03/03/3333", amount));
        ordersList.add(new GetResponse.Orders("4444", customer, "OK4", "04/04/4444", amount));

        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new OrderAdapter(ordersList,this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
}
