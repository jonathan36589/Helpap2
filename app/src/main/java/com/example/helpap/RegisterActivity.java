package com.example.helpap;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "jonathan";

    Button buttonLog3;
    TextView loginTxt2;
    private FirebaseAuth mAuth;
    EditText email,passwrd,username;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();


        buttonLog3 = findViewById(R.id.buttonLog3);
        buttonLog3.setOnClickListener(this);
        Log.d(TAG, "onCreate: 12");

        //-----------------------------------------------------------------------

        loginTxt2 = findViewById(R.id.loginTxt2);
        loginTxt2.setOnClickListener(this);
        Log.d(TAG, "onCreate: 14");


        email = findViewById(R.id.email);
        email.setOnClickListener(this);
        String tempEmail = email.toString().trim();

        passwrd = findViewById(R.id.Password);
        passwrd.setOnClickListener(this);
        String tempPassword = passwrd.toString().trim();


       username = findViewById(R.id.Username);
       username.setOnClickListener(this);
       String tempUsername = username.toString().trim();


    }

    @Override
    public void onClick(View view) {
        Intent intent;
        Log.d(TAG, "onClick: 13" + view.getId() );
        switch (view.getId()){
            case R.id.buttonLog3:
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.loginTxt2:
                intent = new Intent(this,LoginActivity.class);
                startActivity(intent);


// intent = new Intent(this,LoginActivity.class);
// startActivity(intent);
                break;
        }

    }





    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // [END create_user_with_email]

    }



}
