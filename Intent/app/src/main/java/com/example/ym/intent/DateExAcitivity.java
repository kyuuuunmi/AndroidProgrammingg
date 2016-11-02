package com.example.ym.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DateExAcitivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_ex_acitivity);
        Button btnTime = (Button)findViewById(R.id.btnTime);
        Button btnDate = (Button)findViewById(R.id.btnDate);
        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnTime:
                intent = new Intent();
                intent.setAction("com.example.ym.intent.action.showtime");
                //intent = new Intent();
                startActivity(intent);
                break;
            case R.id.btnDate:
                intent = new Intent();
                intent.setAction("com.example.ym.intent.action.showdate");
                startActivity(intent);
                break;
        }
    }
}
