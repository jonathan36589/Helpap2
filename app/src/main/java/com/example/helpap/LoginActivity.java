package com.example.helpap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "jonathan";
    Button buttonLog;
    TextView signinTxt,forgotP;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signinTxt = findViewById(R.id.signinTxt);
        signinTxt.setOnClickListener(this);
        Log.d(TAG, "onCreate: 3");

        //----------------------------------------------------------------------------

        buttonLog = findViewById(R.id.buttonLog);
        buttonLog.setOnClickListener(this);
        Log.d(TAG, "onCreate: 6");

        //----------------------------------------------------------------------------

        forgotP = findViewById(R.id.forgotP);
        forgotP.setOnClickListener(this);
        Log.d(TAG, "onCreate: 8");

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        Log.d(TAG, "onClick: 4" + view.getId() );
        switch (view.getId()){
            case R.id.signinTxt:
                Log.d(TAG, "onClick: 5");
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonLog:
                Log.d(TAG, "onClick: 7");
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.forgotP:
                Log.d(TAG, "onClick: 9");
                intent = new Intent(this,forgotActivity.class);
                startActivity(intent);

        }

    }
}

