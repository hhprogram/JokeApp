package com.example.harrison.myapplication.backend;

import com.example.JokeLib;

import java.util.Random;

/**
 * Created by harrison on 5/17/17.
 */

public class MyJoke {
    private String joke;


    public String getData() {
        return joke;
    }


    //    method to actually retrieve the joke from the java library and then sets it to the prviate
//    String var JOKE. for now just naming as setData as only methods that I see when calling this
//    type of object outside of my backend module are methods with setData or getData in the front
    public void setData() {
        JokeLib jokes = new JokeLib(10);
        Random rand = new Random();
        int num = rand.nextInt(jokes.get_num_jokes());
        joke = jokes.getAJoke(num);
    }

    public void netData() {

    }
}
