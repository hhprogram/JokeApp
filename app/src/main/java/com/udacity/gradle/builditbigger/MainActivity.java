package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.JokeLib;
import com.example.Triple;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    the java library is basically just a module where I can put util functions / classes. Then
//    i just import it like any other module and create instance objects when necessary just like
//    if it was just another class within the same module. Easiest way to do it is to do:
//    new -> new module -> java library. and it will set a bunch of stuff up for you.
//    just need to make sure this app's build.gradle file know that it depends on the newly created
//    java library so need to add compile project(':JokeLib') in the dependencies section
    public void tellJoke(View view) {
        JokeLib jokelib = new JokeLib();
        jokelib.popJokes(10);
        Random rand = new Random();
        int joke_num = rand.nextInt(jokelib.get_num_jokes());
//        String new_joke = joke.getAJoke(joke_num);
//        right now this first will show the toast with new_joke and then it will start the activity
//        or if the toast is after it will start the activity and then show the toast. However,
//        either way the toast is shown with this new_joke's value. And then since we start the
//        droidjoke main activity - the next time we click the button the droidjoke's tellJoke()
//        function is called and not this one
//        this would create an asynctask and gives it a pair argument
        new EndpointsAsyncTask().execute(new Triple<Context, JokeLib, Integer>(this, jokelib
                , joke_num));

    }


}
