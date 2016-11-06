package com.example.ym.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PassingToAcitivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_to_acitivity);

        textView = (TextView)findViewById(R.id.txt_passingto);
        Intent intent = getIntent();
        String fName = intent.getStringExtra("first");
        String lname = intent.getStringExtra("last");
        textView.setText("Your Name is : " +fName + " " + lname );


    }
}
