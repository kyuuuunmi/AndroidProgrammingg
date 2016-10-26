package com.example.ym.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SenderActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.ym.intent.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
    }



    public void sendMessage(View view){
        Intent intent = new Intent(this, ReceiverActivity.class);
        EditText editText = (EditText)findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

