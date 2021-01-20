package com.example.digitalkeyboard;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    protected final static int MAIN_THEME = 0;
    protected final static int PSYCHEDELIC_THEME = 1;
    protected final static int RED_THEME = 2;
    private static final String APP_THEME_CHOOSEN = "APP_THEME_CHOOSEN";
    private static final String APP_THEME_SAVED = "APP_THEME_SAVED";
    private static final String PREFERENCES_NAME = "CALCULATOR";
    protected int themeChoosen;
    protected int themeSaved;

    protected int getThemeChoosen() {
        return themeChoosen;
    }

    protected void setThemeChoosen(int themeChoosen) {
        this.themeChoosen = themeChoosen;
    }

    protected int getThemeSaved() {
        return themeSaved;
    }

    protected void setThemeSaved(int themeSaved) {
        this.themeSaved = themeSaved;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeSaved(getAppThemeSaved(R.style.Theme_DigitalKeyboard));
        setThemeChoosen(getAppThemeChoosen(R.style.Theme_DigitalKeyboard));
    }

    protected int getAppTheme(int themeId) {
        return codeStyleToStyleId(themeId);
    }

    protected int getAppThemeChoosen(int appThemeDefault) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME_CHOOSEN, appThemeDefault);
    }
    protected int getAppThemeSaved(int appThemeDefault) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME_SAVED, appThemeDefault);
    }
    protected void setAppTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_THEME_CHOOSEN, getThemeChoosen());
        editor.putInt(APP_THEME_SAVED, getThemeSaved());
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
