package com.appsnipp.loginsamples;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginAPI {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login( @Field("list") String list,
            @Field("username") String username,
                             @Field("password") String password);
}
