package com.example.lab2;

public class SecondScreenModel {

    private String time;
    private String quote;

    public SecondScreenModel(String time, String quote){
        this.quote = quote;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

}
