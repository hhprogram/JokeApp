package com.example;

/**
 * Created by harrison on 5/18/17. Remember to have this work I need to compile Junit tests in this
 * module's dependencies block in its build.gradle file
 */
public class JokeLibTest {
    @org.junit.Test
    public void getAJoke() throws Exception {
        JokeLib jokes = new JokeLib(10);
        assert jokes.getAJoke(5).equals("joke5");

    }

}