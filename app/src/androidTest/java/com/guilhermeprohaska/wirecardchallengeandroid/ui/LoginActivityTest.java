package com.guilhermeprohaska.wirecardchallengeandroid.ui;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.guilhermeprohaska.wirecardchallengeandroid.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginActivityIsDisplayedTest() {
        onView(withId(R.id.editTextUsernameId))
                .check(matches(isDisplayed()));

        onView(withId(R.id.editTextUsernameId))
                .check(matches(withText("")));

        onView(withId(R.id.editTextPasswordId))
                .check(matches(isDisplayed()));

        onView(withId(R.id.editTextPasswordId))
                .check(matches(withText("")));

        onView(withId(R.id.buttonLoginId))
                .check(matches(isDisplayed()));
    }
}
