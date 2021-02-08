package com.example.testeandroidv2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("user")
    @Expose
    private String user;

    @SerializedName("password")
    @Expose
    private String password;

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
