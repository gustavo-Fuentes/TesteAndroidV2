package com.example.testeandroidv2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testeandroidv2.R;
import com.example.testeandroidv2.api.ApiClient;
import com.example.testeandroidv2.model.LoginRequest;
import com.example.testeandroidv2.model.LoginResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText userInput, passwordInput;
    Button btn_Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userInput = findViewById(R.id.userInput);
        passwordInput = findViewById(R.id.passwordInput);
        btn_Send = findViewById(R.id.send);

    }

    private void checkLogin(String user, String password) {

        LoginRequest loginRequest = new LoginRequest(user, password);

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);


        if (userValidate(user) && passwordValidate(password)) {

            loginResponseCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NotNull Call<LoginResponse> call, @NotNull Response<LoginResponse> response) {

                    LoginResponse loginResponse = response.body();
                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(@NotNull Call<LoginResponse> call, @NotNull Throwable t) {
                }
            });


        }

        else {
            Toast.makeText(LoginActivity.this, "Failed in validated the user or password ", Toast.LENGTH_SHORT).show();
        }


    }

    public boolean userValidate(String usr) {

        String cpf_regex = "\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}";
        String email_regex = "\\S+@\\S+\\.\\S+";

        boolean cpfValidate = usr.matches(cpf_regex) && usr.length() == 11;
        boolean emailValidate = usr.matches(email_regex);

        return cpfValidate || emailValidate;
    }

    public boolean passwordValidate(String password) {

        String password_regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%&+^=])(?=\\S+$).{4,}$";
        return password.matches(password_regex);
    }


    public void onLogin(View view) {

        String user = userInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (user.length() <= 0 || password.length() <= 0) {
            Toast.makeText(LoginActivity.this, "user and password are require" + user, Toast.LENGTH_SHORT).show();
        }

        else {

            checkLogin(user, password);

        }

    }
}