package com.example.testeandroidv2.api;


import com.example.testeandroidv2.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceAPI {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> getLogin(@Field("user") String login,
                                 @Field("password") String password);



//    @GET("statements/{userId}")
//    Call<String> getUserDetail();
}
