package com.guilhermeprohaska.wirecardchallengeandroid.ui;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.guilhermeprohaska.wirecardchallengeandroid.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasFocus;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    private String correct_username = "moip-test-developer@moip.com.br";
    private String wrong_username = "";
    private String correct_password = "testemoip123";
    private String wrong_password = "123";

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

    @Test
    public void loginIsEmpty(){
        onView(withId(R.id.editTextUsernameId))
                .perform(replaceText(wrong_username));

        onView(withId(R.id.buttonLoginId))
                .perform(click());

        onView(withId(R.id.editTextUsernameId))
                .check(matches(hasFocus()));
    }

    @Test
    public void passwordIsEmpty(){

        onView(withId(R.id.editTextUsernameId))
                .perform(replaceText(correct_username));

        onView(withId(R.id.editTextPasswordId))
                .perform(replaceText(wrong_username));

        onView(withId(R.id.buttonLoginId))
                .perform(click());

        onView(withId(R.id.editTextPasswordId))
                .check(matches(hasFocus()));
    }

    @Test
    public void passwordHaveLessThanSixCharacter(){

        onView(withId(R.id.editTextUsernameId))
                .perform(replaceText(correct_username));

        onView(withId(R.id.editTextPasswordId))
                .perform(replaceText(wrong_password));

        onView(withId(R.id.buttonLoginId))
                .perform(click());

        onView(withId(R.id.editTextPasswordId))
                .check(matches(hasFocus()));
    }
}
