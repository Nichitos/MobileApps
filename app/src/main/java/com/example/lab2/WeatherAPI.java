package com.example.lab2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

        @GET("data/2.5/weather")
        Call< WResponse > getWeatherByCity(@Query("q") String city, @Query("APPID") String apiKey);

}
