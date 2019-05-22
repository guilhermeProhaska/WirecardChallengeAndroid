package com.guilhermeprohaska.wirecardchallengeandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.guilhermeprohaska.wirecardchallengeandroid.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsernameId);
        editTextPassword = findViewById(R.id.editTextPasswordId);

        findViewById(R.id.buttonLoginId).setOnClickListener(this);
        findViewById(R.id.editTextLostPasswordId).setOnClickListener(this);
        findViewById(R.id.editTextCreateNewPasswordId).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonLoginId:
                userSignUp();
                break;
            case R.id.editTextLostPasswordId:
                break;
            case R.id.editTextCreateNewPasswordId:
                break;
        }
    }

    private void userSignUp() {

        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if(username.isEmpty()){
            editTextUsername.setError("Username is required!");
            editTextUsername.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length() < 6){
            editTextPassword.setError("Password should be at least 6 characters!");
            editTextPassword.requestFocus();
            return;
        }
    }
}
