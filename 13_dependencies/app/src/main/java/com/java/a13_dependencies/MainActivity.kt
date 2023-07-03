package com.java.a13_dependencies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var image : ImageView = findViewById(R.id.image)
        //image.setImageResource(R.drawable.test)

        Glide.with(this).load(R.drawable.test).into(image)
    }
}