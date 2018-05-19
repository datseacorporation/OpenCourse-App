package com.datseacorporation.opencourse;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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

    private void  userLogin() {
        String email = user_email_et.getText().toString().trim();
        String password = user_password_et.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            //stopping excution
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            //stopping excution
            return;
        }
        // if validate ok
        //show progress bar
        progressDialog.setMessage("Signing In...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            // starting profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Please Check Credentials...", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if(view == user_login_button){
            userLogin();
        }
    }
}
