package com.example.retrofitrecyclearview;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("entries")
    Call<Model> getData();
}
