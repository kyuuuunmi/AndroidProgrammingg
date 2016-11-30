package com.example.ym.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PreferenceActivity extends android.preference.PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_Preference);
        addPreferencesFromResource(R.layout.activity_preference);
    }




}
