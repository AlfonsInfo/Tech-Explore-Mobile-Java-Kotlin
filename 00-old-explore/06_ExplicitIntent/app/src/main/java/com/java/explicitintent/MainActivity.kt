package com.java.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

//MainActivity Extends AppCompatActivity
class MainActivity : AppCompatActivity() {

    //Deklarasi langsung di sini tidak akan berfungsi dengan benar
    //var tvTitle : TextView = findViewById(R.id.textView)
    //var btnMove : Button = findViewById(R.id.button)
    private lateinit var tvTitle : TextView;
    private lateinit var btnMove : TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTitle =  findViewById(R.id.textView)
        btnMove = findViewById(R.id.button)

        btnMove.setOnClickListener {
            //Intent = Representasi aksi yang mau dilakukan (Explicit Intent)
            var i = Intent(this,Activity2::class.java)
            //Aksi
            startActivity(i);
        }
    }
}