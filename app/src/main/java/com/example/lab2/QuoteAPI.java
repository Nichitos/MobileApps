package com.example.lab2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuoteAPI {

    @GET("qod")
    Call<QResponseModel> getQuoteOfTheDay(@Query("lanugage") String language);
}
