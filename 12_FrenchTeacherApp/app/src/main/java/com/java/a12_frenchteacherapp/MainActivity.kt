package com.java.a12_frenchteacherapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun sayTheColor(view: View){

        var clicked_btn  =   view as Button;

        var mediaPlayer = MediaPlayer.create(
            this,
            resources.getIdentifier( clicked_btn.tag.toString().toLowerCase(), "raw",packageName)
        )
        mediaPlayer.start()
    }
}