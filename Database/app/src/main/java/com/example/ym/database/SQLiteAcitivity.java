package com.example.ym.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteAcitivity extends AppCompatActivity {

    DBHelper1 helper;
    SQLiteDatabase db;
    EditText edit_name, edit_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        helper = new DBHelper1(this);
        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }

        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_tel = (EditText) findViewById(R.id.edit_tel);
    }

    public void insert(View target){
        String name = edit_name.getText().toString();
        String tel = edit_tel.getText().toString();
        db.execSQL("INSERT INTO contacts VALUES (null, '" + name + "', '" + tel + "');");
        Toast.makeText(getApplicationContext(), "성공적으로 추가되었음", Toast.LENGTH_SHORT).show();
        edit_name.setText("");
        edit_tel.setText("");
    }

    public void search(View target){
        String name = edit_name.getText().toString();
        Cursor cursor;
        cursor = db.rawQuery("SELECT name, tel FROM contacts WHERE name='" + name + "';", null);
        while (cursor.moveToNext()) {
            String tel = cursor.getString(1);
            edit_tel.setText(tel);
        }
    }
}
