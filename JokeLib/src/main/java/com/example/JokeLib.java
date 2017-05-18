package com.example;

import java.util.ArrayList;

public class JokeLib {
    ArrayList<String> jokes = new ArrayList<String>();
    int num_jokes;

    public JokeLib (int num) {

        for (int i=0; i<num; i++) {
            String joke = "joke" + Integer.toString(i);
            jokes.add(joke);
            num_jokes++;
        }
    }

    public String getAJoke(int i) {
        return jokes.get(i);
    }

    public int get_num_jokes() {
        return num_jokes;
    }



}
