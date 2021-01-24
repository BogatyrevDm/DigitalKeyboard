package com.example.digitalkeyboard;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    //Числовые переменные для тем
    protected final static int MAIN_THEME = 0;
    protected final static int PSYCHEDELIC_THEME = 1;
    protected final static int RED_THEME = 2;
    //Ключи для сохранения настроек
    private static final String APP_THEME_CHOOSEN = "APP_THEME_CHOOSEN";
    private static final String APP_THEME_SAVED = "APP_THEME_SAVED";
    private static final String PREFERENCES_NAME = "CALCULATOR";
    //Хранит числовое значение выбранной темы
    protected int themeChoosen;
    //Хранить числовое значение сохраненной темы
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
        //Получим сохраненные числовые значения тем
        //Сами темы будем устанавливать в классах-потомках
        setThemeSaved(getAppThemeSaved(MAIN_THEME));
        setThemeChoosen(getAppThemeChoosen(MAIN_THEME));
    }

    //Получим идентификатор темы из ресурсов по числовому значению темы
    protected int getAppTheme(int themeId) {
        switch (themeId) {
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

    //Получим сохраненную настройку для выбранной темы
    protected int getAppThemeChoosen(int appThemeDefault) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME_CHOOSEN, appThemeDefault);
    }

    //Получим сохраненную настройку для сохраненной темы
    protected int getAppThemeSaved(int appThemeDefault) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME_SAVED, appThemeDefault);
    }

    //Сохраним настройку темы
    protected void setAppTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_THEME_CHOOSEN, getThemeChoosen());
        editor.putInt(APP_THEME_SAVED, getThemeSaved());
        editor.apply();
    }
}
