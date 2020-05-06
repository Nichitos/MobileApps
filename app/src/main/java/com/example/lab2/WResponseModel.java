package com.example.lab2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WResponseModel {

    @SerializedName("main")
    @Expose
    private MainModel main;


    public MainModel getMain() {
        return main;
    }


}
