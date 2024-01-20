package com.java.a01_greetingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaring View
    TextView titleApp;
    Button  buttonSayHello;
    EditText inputName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleApp = findViewById(R.id.textView);
        inputName = findViewById(R.id.editTextTextInputName);
        buttonSayHello = findViewById(R.id.btnSayHello);

        buttonSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();

                Toast.makeText(MainActivity.this, "Hello " + name , Toast.LENGTH_LONG).show();
            }
        });
    }
}