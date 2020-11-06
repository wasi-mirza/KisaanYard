package com.android.kisaanyard.communication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiInterface {

    @Headers("Content-Type:application/json")
    @GET()
    Call<ResponseData> PincodeApi(@Url String url);

}
