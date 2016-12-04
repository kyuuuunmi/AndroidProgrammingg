package com.example.ym.database;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by yuuuunmi on 2016-12-04.
 */

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.activity_preference);
    }
}
