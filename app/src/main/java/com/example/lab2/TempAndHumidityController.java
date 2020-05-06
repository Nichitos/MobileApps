package com.example.lab2;

import android.widget.TextView;

public class TempAndHumidityController {

    private TempAndHumidityModel modelglobal;
    private TextView view;

    public TempAndHumidityController(TempAndHumidityModel model, TextView view) {
        this.modelglobal = model;
        this.view = view;
    }

    public void setModelView(){
        view.setText(modelglobal.getHumidAndTemp());
    }

}
