package com.example.helpap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class welcomeActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "jonathan";
    Button Loginw, signinw;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        Loginw = findViewById(R.id.Loginw);
        Loginw.setOnClickListener(this);
        Log.d(TAG, "onCreate: 1");

        //----------------------------------------------------------------------------

        signinw = findViewById(R.id.signinw);
        signinw.setOnClickListener(this);
        Log.d(TAG, "onCreate: 2");


    }

    @Override
    public void onClick(View view) {
        Intent intent;
        Log.d(TAG, "onClick: " + view.getId() + "text: " + R.id.Loginw + "text: " + R.id.signinw);
        switch (view.getId()) {
            case R.id.Loginw:
                Log.d(TAG, "onClick: 2");
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.signinw:
                Log.d(TAG, "onClick: 3");
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
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
                            Toast.makeText(welcomeActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // [END create_user_with_email]

    }
}