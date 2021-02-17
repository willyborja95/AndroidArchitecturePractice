package com.anncode.offersandcoupons.model;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers

public interface ApiService {
    @GET("getOffers/")
    fun getCoupons(): Call<JsonObject>
}
