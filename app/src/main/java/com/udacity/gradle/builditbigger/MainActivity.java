package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements AsyncListener{

    String joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "in the Main activity one");
        super.onCreate(savedInstanceState);
        Log.d(TAG, "in the Main activity two");
//        note in this app when we call setContentView ->this goes a sets the view to the
//        activity_main xml layout. However, since every fragment needs to be associated with a
//        parent activity (they do this via the xml layout by inserting a fragment layout in the
//        xml of the activity_main layout (see the fragment tag) What this does is then it searches
//        in the xml info under the fragment tag for the 'name' of this fragment which is
//        com.udacity.gradlebuilditbigger.MainActivityFragment and then calls that class to
//        actually inflate the corresponding fragment layout that that java class inflates
//        remember every fragment that is used must be associated with a parent activity. You can
//        either do it programtically and call fragment manager to directly call the fragment java
//        class or do it via xml and set the main activity xml as the layout but then have that
//        layout refer to a fragment which then it must call to inflate the view
        setContentView(R.layout.activity_main);
        Log.d(TAG, "in the Main activity three");

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
//        create an async task, this async task will then use the backend to connect to the JokeLib
//        java library to retrieve a joke for me. Then the backend will return it to the aysncTask
//        who will then have it it its result and then in the asyncTask post execute it will call
//        the onTaskCompletion method to then make this main activity start an intent to show the
//        joke in the android library.
        try {
            Log.d(TAG, "calling asyncTask");
            joke = new EndpointsAsyncTask().execute(this).get();
        } catch (InterruptedException e) {
            Log.d(TAG, "onTellJoke: Interuptted exception when running asynctask");
        } catch (ExecutionException e) {
            Log.d(TAG, "onTellJoke: Execution exception when running asynctask");
        }

    }

    public void onTaskCompletion() {
        Intent intent = new Intent(this, com.harrison.droidjoke.MainActivity.class);
        intent.putExtra(getString(R.string.joke_key), joke);
        startActivity(intent);
    }


}
