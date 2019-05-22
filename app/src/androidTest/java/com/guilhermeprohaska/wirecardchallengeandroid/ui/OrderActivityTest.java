package com.guilhermeprohaska.wirecardchallengeandroid.ui;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.guilhermeprohaska.wirecardchallengeandroid.R;
import com.guilhermeprohaska.wirecardchallengeandroid.entities.GetResponse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class OrderActivityTest {

    @Rule
    public ActivityTestRule<OrderActivity> mActivityTestRule = new ActivityTestRule<>(OrderActivity.class);
    private List<GetResponse.Orders> ordersList = new ArrayList<>();
    private GetResponse.Orders.Customer customer = new GetResponse.Orders.Customer("name1", "email1@gmail.com");
    private GetResponse.Orders.Amount amount = new GetResponse.Orders.Amount("R$ 1111,11");
    //private RecyclerView recyclerView;

    @Test
    public void orderActivityTest() {

        ordersList.add(new GetResponse.Orders("1111", customer, "OK1", "01/01/1111", amount));
        ordersList.add(new GetResponse.Orders("2222", customer, "OK2", "02/02/2222", amount));
        ordersList.add(new GetResponse.Orders("3333", customer, "OK3", "03/03/3333", amount));
        ordersList.add(new GetResponse.Orders("4444", customer, "OK4", "04/04/4444", amount));
/*
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new OrderAdapter(ordersList,this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
*/
        onView(withId(R.id.recyclerViewId))
                        .check(matches(isDisplayed()));
    }
}
