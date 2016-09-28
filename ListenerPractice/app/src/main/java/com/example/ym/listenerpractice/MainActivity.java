package com.example.ym.listenerpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText editText = (EditText) findViewById(R.id.editText);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode== KeyEvent.KEYCODE_ENTER)){
                    Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox5);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( ((CheckBox)v).isChecked())
                    Toast.makeText(getApplicationContext(), "Selected", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), "Not Selected", Toast.LENGTH_SHORT).show();

            }
        });

    }


    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox)view).isChecked();

        switch (view.getId()) {
            case R.id.checkBox1:
                if( checked)    Toast.makeText(getApplicationContext(), "고기선택", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), "고기선택해제", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox2:
                if( checked)    Toast.makeText(getApplicationContext(), "치즈선택", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), "치즈선택해제", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox3:
                if( checked)    Toast.makeText(getApplicationContext(), "치킨선택", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), "치킨선택해제", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox4:
                if( checked)    Toast.makeText(getApplicationContext(), "물선택", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), "물선택해제", Toast.LENGTH_SHORT).show();
                break;

        }

    }

}
