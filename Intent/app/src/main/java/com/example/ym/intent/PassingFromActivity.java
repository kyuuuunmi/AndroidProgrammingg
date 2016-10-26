package com.example.ym.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PassingFromActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit_FirstName;
    EditText edit_LastName;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_from);

        edit_FirstName = (EditText)findViewById(R.id.edit_firstName);
        edit_LastName = (EditText)findViewById(R.id.edit_lastName);
        btn_submit = (Button)findViewById(R.id.btn_Submit);
        btn_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PassingToAcitivity.class);
        intent.putExtra("first", edit_FirstName.getText().toString());
        intent.putExtra("last", edit_LastName.getText().toString());
        startActivity(intent);
    }


}
