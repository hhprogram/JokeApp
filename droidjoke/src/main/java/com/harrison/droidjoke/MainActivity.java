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
//            use the following as this is the system dependent line separator.
//            http://stackoverflow.com/questions/14534767/how-to-append-a-newline-to-stringbuilder
//            can also do output.append("\n") -> but potentially won't work with some systems so
//            more general if do this
            output.append(System.getProperty("line.separator"));
        }
        text.setText(output.toString());
//        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
        Log.d(TAG, "in the android lib activity");
    }

}
