package com.example.lab2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QResponseModel {

    @SerializedName("contents")
    @Expose
    private ContentsModel contents;


    public ContentsModel getContents() {
        return contents;
    }

}
