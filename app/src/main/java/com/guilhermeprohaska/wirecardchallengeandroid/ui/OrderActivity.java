package com.guilhermeprohaska.wirecardchallengeandroid.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Base64;
import android.widget.Toast;

import com.guilhermeprohaska.wirecardchallengeandroid.R;
import com.guilhermeprohaska.wirecardchallengeandroid.adapter.OrderAdapter;
import com.guilhermeprohaska.wirecardchallengeandroid.entities.GetResponse;
import com.guilhermeprohaska.wirecardchallengeandroid.service.RetrofitOrder;
import com.guilhermeprohaska.wirecardchallengeandroid.storage.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private int responseCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        final OrderAdapter orderAdapter = new OrderAdapter(this);
        recyclerView.setAdapter(orderAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        Call<List<GetResponse>> ordersCall = RetrofitOrder
                .getInstance()
                .getOrderRetrofit()
                .getRequest(Base64.encodeToString((
                        SharedPreferencesManager.getInstance(OrderActivity.this).getPostResponse().getAccessToken()).getBytes(),Base64.NO_WRAP));

        ordersCall.enqueue(new Callback<List<GetResponse>>() {
            @Override
            public void onResponse(Call<List<GetResponse>> call, Response<List<GetResponse>> response) {

                responseCode = response.code();

                if(response.body() != null){
                    Toast.makeText(OrderActivity.this,"Get Successful!" + responseCode, Toast.LENGTH_LONG).show();
                    orderAdapter.setOrdersList(response.body());

                } else {
                    Toast.makeText(OrderActivity.this,"Get error\n!" + response.errorBody(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetResponse>> call, Throwable t) {
                Toast.makeText(OrderActivity.this,"Failure Get\n" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
