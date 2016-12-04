package com.example.ym.database;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PreferenceActivity extends android.preference.PreferenceActivity {

    public static final String PREFS_NAME = "MyPrefs";
    TextView name;
    EditText value;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preftest);
       // addPreferencesFromResource(R.layout.activity_preference);

        name = (TextView)findViewById(R.id.txt_img);
        value = (EditText)findViewById(R.id.edit_img);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        imageName = settings.getString("imageName", "");
        value.setText(imageName);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        imageName = value.getText().toString();
        editor.putString("imageName", imageName);
        editor.commit();
    }
}
