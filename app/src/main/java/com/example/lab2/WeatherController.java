package com.example.lab2;

import android.app.Activity;

public class WeatherController {

    private WResponseModel model;
    private Activity view;

    public WeatherController(WResponseModel model, Activity view){
        this.model = model;
        this.view = view;
    }

    public void setView(WResponseModel mdl){
        model = mdl;
    }
}
