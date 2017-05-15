package com.example;

/**
 * Created by harrison on 5/15/17.
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
