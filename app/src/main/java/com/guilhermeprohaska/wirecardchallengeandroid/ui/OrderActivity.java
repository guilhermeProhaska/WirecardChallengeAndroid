package com.guilhermeprohaska.wirecardchallengeandroid.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.guilhermeprohaska.wirecardchallengeandroid.R;
import com.guilhermeprohaska.wirecardchallengeandroid.adapter.OrderAdapter;
import com.guilhermeprohaska.wirecardchallengeandroid.entities.Orders;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private List<Orders> ordersList = new ArrayList<>();
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ordersList.add(new Orders("1111", "email1@gmail.com", "OK1", "01/01/1111", "R$ 1111,11"));
        ordersList.add(new Orders("2222", "email2@gmail.com", "OK2", "02/02/2222", "R$ 2222,22"));
        ordersList.add(new Orders("3333", "email3@gmail.com", "OK3", "03/03/3333", "R$ 3333,33"));
        ordersList.add(new Orders("4444", "email4@gmail.com", "OK4", "04/04/4444", "R$ 4444,44"));

        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new OrderAdapter(ordersList,this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
}
