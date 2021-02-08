package com.example.testeandroidv2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testeandroidv2.R;
import com.example.testeandroidv2.api.InterfaceAPI;
import com.example.testeandroidv2.api.RetrofitClientInstance;
import com.example.testeandroidv2.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    EditText userInput, passwordInput;
    Button btn_Send;

    //test_user
    //Test@1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userInput = findViewById(R.id.userInput);
        passwordInput = findViewById(R.id.passwordInput);
        btn_Send = findViewById(R.id.send);

        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = userInput.getText().toString();
                String password = passwordInput.getText().toString();
                //String authToken = createAuthToken(user,password);

                checkLogin();
                System.out.println(user);

            }
        });
    }



    private void checkLogin(){
        Intent i = new Intent(LoginActivity.this,  CurrencyActivity.class);
        Retrofit retro = RetrofitClientInstance.getRetrofitInstance();
        final InterfaceAPI api = retro.create(InterfaceAPI.class);

        Call<LoginResponse> call = api.getLogin("test_user", "Test@1");

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){

                    System.out.println(response.body().getUser() + " / " + response.body().getPassword());

                    if(response.body().getUser().equals("test_us")){
                        startActivity(i);
                    }


                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("TAG", t.toString());
                t.printStackTrace();
            }
        });
    }




}