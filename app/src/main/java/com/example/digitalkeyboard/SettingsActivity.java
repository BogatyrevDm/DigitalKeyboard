package com.example.digitalkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initThemeChooser();
        initButtons();
    }

    private void initButtons() {
        Button buttonOk = findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }


        );
    }

    private void initThemeChooser() {
        initRadioButtonListener(findViewById(R.id.radio_button_main_theme), MAIN_THEME);
        initRadioButtonListener(findViewById(R.id.radio_button_psychedelic_theme), PSYCHEDELIC_THEME);
        initRadioButtonListener(findViewById(R.id.radio_button_red_theme), RED_THEME);
    }

    private void initRadioButtonListener(View viewById, int mainTheme) {


        viewById.setOnClickListener(v -> {

        });
    }
}
