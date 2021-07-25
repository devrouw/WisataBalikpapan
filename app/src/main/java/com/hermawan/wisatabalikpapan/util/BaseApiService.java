package com.hermawan.wisatabalikpapan.util;

import com.hermawan.wisatabalikpapan.model.ListTravel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BaseApiService {
    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/login.php
    @FormUrlEncoded
    @POST("api.php")
    Call<ResponseBody> register(@Field("case") String cases,
                                @Field("name") String name,
                                @Field("email") String email,
                                @Field("password") String password);

    @FormUrlEncoded
    @POST("api.php")
    Call<ResponseBody> login(@Field("case") String cases,
                                @Field("email") String email,
                                @Field("password") String password);

    @Headers("Content-Type: application/json")
    @POST("validate_token_api.php")
    Call<ResponseBody> validateUser(@Header("Authorization") String token,
                                    @Body String body);

    @FormUrlEncoded
    @POST("api.php")
    Call<ListTravel> getTravel(@Field("case") String cases);

    @FormUrlEncoded
    @POST("api.php")
    Call<ListTravel> getHotel(@Field("case") String cases);
}
