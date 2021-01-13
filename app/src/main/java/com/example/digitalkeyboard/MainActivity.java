package com.example.digitalkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Calculator calculator;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonComma;
    private Button buttonEqual;
    private Button buttonChangeSing;
    private Button buttonClearAll;
    private Button buttonClearOne;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonPlus;
    private Button buttonMinus;
    private TextView textViewShowResult;
    private TextView textViewEnterNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new Calculator();
        initView();
    }

    private void initView() {
        findViews();
        setClickListeners();
    }

    //setting clickListeners
    private void setClickListeners() {
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonComma.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonChangeSing.setOnClickListener(this);
        buttonClearAll.setOnClickListener(this);
        buttonClearOne.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        textViewShowResult.setOnClickListener(this);
        textViewEnterNumbers.setOnClickListener(this);
    }

    //finding views needed
    private void findViews() {
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonComma = findViewById(R.id.button_comma);
        buttonEqual = findViewById(R.id.button_equal);
        buttonChangeSing = findViewById(R.id.button_change_sing);
        buttonClearAll = findViewById(R.id.button_clear_all);
        buttonClearOne = findViewById(R.id.button_clear_one);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonDivide = findViewById(R.id.button_divide);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        textViewShowResult = findViewById(R.id.show_result_textview);
        textViewEnterNumbers = findViewById(R.id.enter_numbers_textview);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.button_0):
                setNumber(R.id.button_0);
                break;
            case (R.id.button_1):
                setNumber(R.id.button_1);
                break;
            case (R.id.button_2):
                setNumber(R.id.button_2);
                break;
            case (R.id.button_3):
                setNumber(R.id.button_3);
                break;
            case (R.id.button_4):
                setNumber(R.id.button_4);
                break;
            case (R.id.button_5):
                setNumber(R.id.button_5);
                break;
            case (R.id.button_6):
                setNumber(R.id.button_6);
                break;
            case (R.id.button_7):
                setNumber(R.id.button_7);
                break;
            case (R.id.button_8):
                setNumber(R.id.button_8);
                break;
            case (R.id.button_9):
                setNumber(R.id.button_9);
                break;
            case (R.id.button_comma):
                setComma();
                break;
            case (R.id.button_equal):
                setEqual();
                break;
            case (R.id.button_change_sing):
                setChangeSing();
                break;
            case (R.id.button_clear_all):
                cleatAll();
                break;
            case (R.id.button_clear_one):
                clearOne();
                break;
            case (R.id.button_multiply):
                setSing(R.id.button_multiply);
                break;
            case (R.id.button_divide):
                setSing(R.id.button_divide);
                break;
            case (R.id.button_plus):
                setSing(R.id.button_plus);
                break;
            case (R.id.button_minus):
                setSing(R.id.button_minus);
                break;
        }
    }
    private void setNumber(int buttonId) {

    }

    private void setComma() {

    }

    private void setEqual() {

    }

    private void setChangeSing() {

    }

    private void cleatAll() {

    }

    private void clearOne() {

    }

    private void setSing(int buttonId) {

    }
}