package com.dsdm.yuuuuunmi.sujin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    EditText editText1, editText2;
    TextView op1,op,op2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText1=(EditText)findViewById(R.id.opr1);
        editText2=(EditText)findViewById(R.id.opr2);
        tv=(TextView)findViewById(R.id.res);
    }

    public void mul(View v){
        int num1=Integer.parseInt(editText1.getText().toString());
        int num2=Integer.parseInt(editText2.getText().toString());
        int result=num1+num2;
        op1.setText(num1);
        op.setText("+");
        op2.setText(num2);
        tv.setText(result);
    }

    public void min(View v){
        int num1=Integer.parseInt(editText1.getText().toString());
        int num2=Integer.parseInt(editText2.getText().toString());
        int result=num1-num2;
        op1.setText(num1);
        op.setText("-");
        op2.setText(num2);
        tv.setText(result);
    }

    public void multi(View v){
        int num1=Integer.parseInt(editText1.getText().toString());
        int num2=Integer.parseInt(editText2.getText().toString());
        int result=num1*num2;
        op1.setText(num1);
        op.setText("*");
        op2.setText(num2);
        tv.setText(result);
    }

    public void div(View v){
        int num1=Integer.parseInt(editText1.getText().toString());
        int num2=Integer.parseInt(editText2.getText().toString());
        int result=num1/num2;
        op1.setText(num1);
        op.setText("/");
        op2.setText(num2);
        tv.setText(result);
    }
}
