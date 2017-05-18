package com.example;

/**
 * Created by harrison on 5/15/17.
 * Was going to use to feed into the AsyncTask but changed implementation so no longer need this
 * currently. Good practice in creating a small custom class to help hold data
 */

public class Triple <T, U, V> {
    private T firstEl;
    private U secondEl;
    private V thirdEl;

    public Triple (T first, U second, V third) {
        firstEl = first;
        secondEl = second;
        thirdEl = third;
    }

    public T getFirst() {
        return firstEl;
    }

    public U getSecond() {
        return secondEl;
    }

    public V getThird() {
        return thirdEl;
    }
}
