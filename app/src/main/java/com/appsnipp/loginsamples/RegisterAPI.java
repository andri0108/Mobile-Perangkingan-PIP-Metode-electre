package com.appsnipp.loginsamples;

import android.renderscript.Sampler;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/daftar.php")

    Call<Value> daftar(
            @Field("kode_alternatif") String kode_alternatif,
            @Field(" id_KIP") String  id_KIP,
            @Field("nama_alternatif") String nama_alternatif,
            @Field("asal_sekolah") String asal_sekolah,
            @Field("username") String username,
            @Field("password") String password);
}
