package com.harrison.droidjoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = this.getIntent();
        String joke = intent.getStringExtra(getString(R.string.joke_key));
        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
        Log.d(TAG, "in the android lib activity");
    }


    public void tellJoke(View view) {
//        String joke = intent.getStringExtra("joke");
        String joke = "helkjl";
        Log.d(TAG, "in the android tell joke function");
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }
}
