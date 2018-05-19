package com.datseacorporation.opencourse;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    // Declearing objects members of button and edittext
    EditText user_email_et,user_password_et;
    Button user_login_button;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // if user already logged-in then do this
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null){
            // instance profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
        }
        // init of object members
        user_email_et = findViewById(R.id.user_email_et);
        user_password_et = findViewById(R.id.user_password_et);
        user_login_button = findViewById(R.id.user_login_button);
        progressDialog = new ProgressDialog(this);
        user_login_button.setOnClickListener(this);


    }

    



    @Override
    public void onClick(View view) {
        if(view == user_login_button){
            userLogin();
        }
    }
}
