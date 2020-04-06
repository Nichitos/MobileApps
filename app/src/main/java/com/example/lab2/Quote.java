package com.example.lab2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quote {

    @SerializedName("quote")
    @Expose
    private String quote;

    public String getQuote() {
        return quote;
    }
}
