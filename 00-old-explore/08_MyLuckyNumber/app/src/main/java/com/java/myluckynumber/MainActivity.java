package com.java.myluckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle;
    EditText inputNama;
    Button Signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.textTitle);
        inputNama = findViewById(R.id.etSignName);
        Signin = findViewById(R.id.btnSignIn);

        Signin.setOnClickListener(v->{

            String nama = inputNama.getText().toString();
            // Explicit Intent
            Intent intent = new Intent(getApplicationContext(), LuckyActivity.class);

            intent.putExtra("nama", nama);

            startActivity(intent);
        });
    }


}