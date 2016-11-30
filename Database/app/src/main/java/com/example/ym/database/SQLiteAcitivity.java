package com.example.ym.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SQLiteAcitivity extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;
    EditText edit_name, edit_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();
        }catch (SQLiteException ex){
            db = helper.getReadableDatabase();
        }

        edit_name = (EditText)findViewById(R.id.edit_name);
        edit_tel = (EditText)findViewById(R.id.edit_tel);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                String tel = edit_tel.getText().toString();
                db.execSQL("INSERT INTO contact VALUES (null, '" + name + "', '" + tel + "');");
            }
        });

        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                Cursor cursor;
                cursor = db.rawQuery("SELECT name, tel FROM contact WHERE name='" + name + "';", null);
                while(cursor.moveToNext()){
                    String tel = cursor.getString(1);
                    edit_tel.setText(tel);
                }
            }
        });

    }
}
