package com.java.a03_unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView titleApp, resultValue;
    EditText inputKilos;
    Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleApp = findViewById(R.id.titleApp);
        resultValue = findViewById(R.id.resultValue);
        inputKilos = findViewById(R.id.etInputValue);
        buttonConvert = findViewById(R.id.btnConvert);

        buttonConvert.setOnClickListener(v -> {
            Double valueInKilo = Double.parseDouble( inputKilos.getText().toString());
            resultValue.setText(""+convertToPound(valueInKilo));
        });
    }


    public Double convertToPound(Double valueInKilos){
        return valueInKilos * 2.20462;
    }
}