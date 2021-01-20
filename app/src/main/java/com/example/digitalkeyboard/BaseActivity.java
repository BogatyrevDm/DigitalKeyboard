package com.example.digitalkeyboard;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    protected final static int MAIN_THEME = 0;
    protected final static int PSYCHEDELIC_THEME = 1;
    protected final static int RED_THEME = 2;
    private static final String APP_THEME = "APP_THEME";
    private static final String PREFERENCES_NAME = "CALCULATOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.Theme_DigitalKeyboard));
    }

    private int getAppTheme(int themeId) {
        return codeStyleToStyleId(getCodeStyle(themeId));
    }

    protected int getCodeStyle(int appThemeDefault) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME, appThemeDefault);
    }

    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_THEME, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case MAIN_THEME:
                return R.style.Theme_DigitalKeyboard;
            case PSYCHEDELIC_THEME:
                return R.style.Theme_Psychedelic;
            case RED_THEME:
                return R.style.Theme_Red;
            default:
                return R.style.Theme_DigitalKeyboard;
        }
    }
}
