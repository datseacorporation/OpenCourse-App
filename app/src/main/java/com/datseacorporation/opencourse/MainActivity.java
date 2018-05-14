package com.datseacorporation.opencourse;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        }, SPLASH_TIME_OUT);


    }
}
