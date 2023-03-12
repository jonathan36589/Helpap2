package com.example.helpap;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class forgotActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "jonathan";

    TextView logintext2;
    Button buttonLog2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        buttonLog2 = findViewById(R.id.buttonLog2);
        buttonLog2.setOnClickListener(this);
        Log.d(TAG, "onCreate: 9");

        //---------------------------------------------------------------------

        logintext2 = findViewById(R.id.logintext2);
        logintext2.setOnClickListener(this);
        Log.d(TAG, "onCreate: 11");

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        Log.d(TAG, "onClick: 10" + view.getId() );
        switch (view.getId()){
            case R.id.buttonLog2:
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.logintext2:
                intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
        }



    }
}