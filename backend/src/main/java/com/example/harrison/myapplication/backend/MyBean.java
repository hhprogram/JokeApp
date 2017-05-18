package com.example.harrison.myapplication.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myData;

    public String getData() {
        return "hello";
    }

    public void setData(String data) {
        myData = data;
    }

    public String nomData() { return "nom";}
}