package com.harrison.droidjoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    StringBuilder output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_droid);
        TextView text = (TextView) findViewById(R.id.textViewDroid);
        intent = this.getIntent();
        ArrayList<String> jokes = intent.getStringArrayListExtra(getString(R.string.joke_key));
        output = new StringBuilder();
        for (String joke : jokes) {
            output.append(joke);
            output.append(System.getProperty("line.separator"));
        }
        text.setText(output.toString());
//        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
        Log.d(TAG, "in the android lib activity");
    }



}
