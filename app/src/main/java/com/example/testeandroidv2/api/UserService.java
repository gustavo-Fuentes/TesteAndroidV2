package com.example.testeandroidv2.api;


import com.example.testeandroidv2.model.LoginRequest;
import com.example.testeandroidv2.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @POST("login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);



//    @GET("statement/{userId}")
//    Call<StatementList> getStatements(@Path("userId") int userId);
}
