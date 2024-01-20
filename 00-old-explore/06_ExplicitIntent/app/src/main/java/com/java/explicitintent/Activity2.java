package com.java.explicitintent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

class Activity2 extends AppCompatActivity() {

    @Override
    public void onCreate( Bundle savedInstanceState?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
    }
}