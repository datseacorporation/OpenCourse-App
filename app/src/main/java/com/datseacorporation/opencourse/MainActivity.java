package com.datseacorporation.opencourse;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(new Runnable() {
            public void run() {

                // if user already logged-in then do this
                firebaseAuth = FirebaseAuth.getInstance();
                if(firebaseAuth.getCurrentUser() !=null){
                    // instance profile activity here
                    finish();
                    startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                }
                else {
                    finish();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }

            }
        }, SPLASH_TIME_OUT);


    }
}
