package com.example.lab2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentsModel {

    @SerializedName("quotes")
    @Expose
    private QuoteModel[] quotes;

    public QuoteModel[] getQuotes() {
        return quotes;
    }
}
