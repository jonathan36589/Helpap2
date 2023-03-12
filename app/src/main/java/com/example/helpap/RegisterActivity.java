package com.example.helpap;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "jonathan";

    Button buttonLog3;
    TextView loginTxt2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonLog3 = findViewById(R.id.buttonLog3);
        buttonLog3.setOnClickListener(this);
        Log.d(TAG, "onCreate: 12");

        //-----------------------------------------------------------------------

        loginTxt2 = findViewById(R.id.loginTxt2);
        loginTxt2.setOnClickListener(this);
        Log.d(TAG, "onCreate: 14");




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
        }

    }


}
