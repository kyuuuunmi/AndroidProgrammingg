package com.example.ym.eventhandling;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    View myTextView;
    Button button;
    RadioButton radioBtn_red;
    RadioButton radioBtn_blue;
    RadioButton radioBtn_yello;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regListenerOnButton();
    }

    public void regListenerOnButton(){

        button = (Button)findViewById(R.id.button);
        myTextView = (TextView)findViewById(R.id.textView);
        radioBtn_red = (RadioButton)findViewById(R.id.radioBtn_red) ;
        radioBtn_blue =(RadioButton)findViewById(R.id.radioBtn_blue) ;
        radioBtn_yello = (RadioButton)findViewById(R.id.radioBtn_yellow);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        MyRadioButtonHandler rbh = new MyRadioButtonHandler();
        radioBtn_red.setOnClickListener(rbh);
        radioBtn_blue.setOnClickListener(rbh);
        radioBtn_yello.setOnClickListener(rbh);


        MyButtonHandler bh = new MyButtonHandler();
        button.setOnClickListener(bh);


    }

    class MyButtonHandler implements View.OnClickListener {
        public void onClick(View v){
            Random genColor = new Random();
            int red = genColor.nextInt();
            int green = genColor.nextInt();
            int blue = genColor.nextInt();
            myTextView.setBackgroundColor(Color.rgb(red, green, blue));
        }
    }

    class MyRadioButtonHandler implements View.OnClickListener{

        public void onClick(View v){
            boolean checked = ((RadioButton)v).isChecked();
            switch (v.getId()){
                case R.id.radioBtn_red:
                    if(checked)
                        myTextView.setBackgroundColor(Color.RED); break;
                case R.id.radioBtn_blue:
                    if(checked)
                        myTextView.setBackgroundColor(Color.BLUE); break;
                case R.id.radioBtn_yellow:
                    if(checked)
                        myTextView.setBackgroundColor(Color.YELLOW); break;
                default:    break;





            }


        }
    }


    //    Toast.makeText(getApplicationContext(), "Button Pressed", Toast.LENGTH_SHORT).show();



}
