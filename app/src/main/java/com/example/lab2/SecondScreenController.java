package com.example.lab2;

import android.widget.TextView;

public class SecondScreenController {

    private SecondScreenModel model;
    private TextView timeView;
    private TextView quoteView;

    public SecondScreenController(SecondScreenModel model, TextView timeView, TextView quoteView ) {
        this.model = model;
        this.timeView = timeView;
        this.quoteView = quoteView;
    }

    public void setTime() {
        timeView.setText(model.getTime());
    }

    public void setQuote(){
        quoteView.setText(model.getQuote());
    }


}
