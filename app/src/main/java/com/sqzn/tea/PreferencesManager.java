package com.sqzn.tea;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {
    private static PreferencesManager instance;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    private PreferencesManager() {
        preferences = MyApplication.getInstance().getSharedPreferences(
                "Application", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public static PreferencesManager getInstance() {
        if (instance == null) {
            instance = new PreferencesManager();
        }
        return instance;
    }



}
