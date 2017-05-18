package com.harrison.droidjoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_droid);
        TextView text = (TextView) findViewById(R.id.textViewDroid);
        intent = this.getIntent();
        String joke = intent.getStringExtra(getString(R.string.joke_key));
        text.setText(joke);
//        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
        Log.d(TAG, "in the android lib activity");
    }


    public void moreJokes(View view) {
//        String joke = intent.getStringExtra("joke");
        

    }
}
