package com.dsdm.yuuuuunmi.calculator;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_cal1;
    Button btn_cal2;
    Button btn_calX;
    TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btn_cal1 = (Button) findViewById(R.id.btn_cal1);
        btn_cal2 = (Button) findViewById(R.id.btn_cal2);
        btn_calX = (Button) findViewById(R.id.btn_calX);
        txt_result = (TextView) findViewById(R.id.txt_mainResult);
        CalListener listener = new CalListener();
        btn_cal1.setOnClickListener(listener);
        btn_cal2.setOnClickListener(listener);
        btn_calX.setOnClickListener(listener);

    }


    class CalListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            Intent intent;


            if (v.getId() == R.id.btn_cal1)
                intent = new Intent(getApplicationContext(), Calculator1Activity.class);
            else if (v.getId() == R.id.btn_cal2)
                intent = new Intent(getApplicationContext(), Calculator2Activity.class);
            else {
                intent = new Intent();
                intent.setAction("com.dsdm.yuuuuunmi.calculator.cal");
            }
            startActivityForResult(intent, 100);


        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == 200) {
                txt_result.setText("Result : " + data.getStringExtra("RESULT"));
            }
        }

    }


}
