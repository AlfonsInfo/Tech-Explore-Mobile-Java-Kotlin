package com.java.counterapp;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvNumber;
    Button btnClickMe;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        tvNumber = findViewById(R.id.tvNumber);
        btnClickMe = findViewById(R.id.buttonClickMe);


        btnClickMe.setOnClickListener(v -> {
            //parseInt(tvNumber.getText().toString()))
            tvNumber.setText(""+increaseCounter());
        });
    }

    public int increaseCounter(){
//        this.counter++;
        return ++counter;
    }
}