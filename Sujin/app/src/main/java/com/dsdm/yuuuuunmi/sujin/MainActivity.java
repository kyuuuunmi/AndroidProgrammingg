package com.dsdm.yuuuuunmi.sujin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    TextView tv;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bd;
    Button mul, min, multi, div, del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.opr1);
        editText2 = (EditText) findViewById(R.id.opr2);
        tv = (TextView) findViewById(R.id.res);

        findViewById(R.id.n0).setOnClickListener(myClickListener);
        findViewById(R.id.n1).setOnClickListener(myClickListener);
        findViewById(R.id.n2).setOnClickListener(myClickListener);
        findViewById(R.id.n3).setOnClickListener(myClickListener);
        findViewById(R.id.n4).setOnClickListener(myClickListener);
        findViewById(R.id.n5).setOnClickListener(myClickListener);
        findViewById(R.id.n6).setOnClickListener(myClickListener);
        findViewById(R.id.n7).setOnClickListener(myClickListener);
        findViewById(R.id.n8).setOnClickListener(myClickListener);
        findViewById(R.id.n9).setOnClickListener(myClickListener);
        findViewById(R.id.dot).setOnClickListener(myClickListener);
        findViewById(R.id.mul).setOnClickListener(myClickListener);
        findViewById(R.id.min).setOnClickListener(myClickListener);
   //     findViewById(R.id.multi).setOnClickListener(myClickListener);
        findViewById(R.id.div).setOnClickListener(myClickListener);
    }

    Button.OnClickListener myClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            int num1 = Integer.parseInt(editText1.getText().toString());
            int num2 = Integer.parseInt(editText2.getText().toString());

            switch (v.getId()) {
                case R.id.n0:
                    editText1.append("0");
                    break;
                case R.id.n1:
                    editText1.append("1");
                    break;
                case R.id.n2:
                    editText1.append("2");
                    break;
                case R.id.n3:
                    editText1.append("3");
                    break;
                case R.id.n4:
                    editText1.append("4");
                    break;
                case R.id.n5:
                    editText1.append("5");
                    break;
                case R.id.n6:
                    editText1.append("6");
                    break;
                case R.id.n7:
                    editText1.append("7");
                    break;
                case R.id.n8:
                    editText1.append("8");
                    break;
                case R.id.n9:
                    editText1.append("9");
                    break;
                case R.id.dot:
                    editText1.append(".");
                    break;
                case R.id.mul:
                    float r1 = num1 + num2;
                    tv.setText(num1 + " + " + num2 + " = " + r1);
                    break;
                case R.id.min:
                    float r2 = num1 - num2;
                    tv.setText(num1 + " - " + num2 + " = " + r2);
                    break;
                case R.id.multi:
                    float r3 = num1 * num2;
                    tv.setText(num1 + " * " + num2 + " = " + r3);
                    break;
                case R.id.div:
                    float r4 = num1 / num2;
                    tv.setText(num1 + " / " + num2 + " = " + r4);
                    break;
            }
        }
    };
}


