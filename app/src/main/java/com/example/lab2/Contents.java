package com.example.lab2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contents {

    @SerializedName("quotes")
    @Expose
    private Quote[] quotes;

    public Quote[] getQuotes() {
        return quotes;
    }
}
