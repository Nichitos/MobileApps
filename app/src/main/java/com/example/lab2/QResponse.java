package com.example.lab2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QResponse {

    @SerializedName("contents")
    @Expose
    private Contents contents;


    public Contents getContents() {
        return contents;
    }

}
