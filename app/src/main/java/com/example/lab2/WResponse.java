package com.example.lab2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WResponse {

    @SerializedName("main")
    @Expose
    private Main main;


    public Main getMain() {
        return main;
    }


}
