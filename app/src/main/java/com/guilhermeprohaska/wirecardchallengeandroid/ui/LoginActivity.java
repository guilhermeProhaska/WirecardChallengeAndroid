package com.guilhermeprohaska.wirecardchallengeandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.guilhermeprohaska.wirecardchallengeandroid.R;
import com.guilhermeprohaska.wirecardchallengeandroid.entities.PostResponse;
import com.guilhermeprohaska.wirecardchallengeandroid.entities.User;
import com.guilhermeprohaska.wirecardchallengeandroid.service.RetrofitClient;
import com.guilhermeprohaska.wirecardchallengeandroid.storage.SharedPreferencesManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername, editTextPassword;
    private String client_id = "APP-H1DR0RPHV7SP", client_secret = "05acb6e128bc48b2999582cd9a2b9787",
            scope = "APP_ADMIN", grant_type = "password", device_id = "um id para o device", username, password;
    private PostResponse postResponse;
    private int postCode;

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
    protected void onStart() {
        super.onStart();

        if(SharedPreferencesManager.getInstance(this).isLoggedIn()){
            editTextUsername.setText(SharedPreferencesManager.getInstance(this).getUser().getUsername());
            editTextPassword.setText(SharedPreferencesManager.getInstance(this).getUser().getPassword());
            userSignUp();
            callPostResponse();
            userOrders();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        SharedPreferencesManager.getInstance(this).clearUser();
        SharedPreferencesManager.getInstance(this).clearToken();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonLoginId:
                userSignUp();
                callPostResponse();
                userOrders();
                break;
            case R.id.editTextLostPasswordId:
                break;
            case R.id.editTextCreateNewPasswordId:
                break;
        }
    }

    private void userSignUp() {

        editTextUsername.setText("moip-test-developer@moip.com.br");
        editTextPassword.setText("testemoip123");

        username = editTextUsername.getText().toString();
        password = editTextPassword.getText().toString();

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

    private void callPostResponse() {

        Call<PostResponse> call = RetrofitClient
                .getInstance()
                .getClientRetrofit()
                .postRequest(client_id,client_secret,scope,grant_type,device_id,username,password);

        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {

                postCode = response.code();
                postResponse = response.body();

                if(postCode == 200){
                    Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login error!\n"
                            + response.errorBody(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Failure!\n"
                        + t.getMessage(), Toast.LENGTH_LONG).show();
                editTextUsername.setText("Failure!" + t.getMessage());
            }
        });

        if(postCode == 200){
            SharedPreferencesManager.getInstance(LoginActivity.this).saveUser(new User(username,password));
            SharedPreferencesManager.getInstance(LoginActivity.this).savePostResponse(postResponse);
        }
    }

    private void userOrders() {

        startActivity(new Intent(LoginActivity.this, OrderActivity.class));
    }
}
