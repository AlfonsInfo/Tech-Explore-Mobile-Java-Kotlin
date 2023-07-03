package com.java.a11_videoplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Images.Media
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoView = findViewById(R.id.videoView1)
        button = findViewById(R.id.buttonMove)
        videoView.setVideoPath(
            "android.resource://${packageName}/${R.raw.video}"
        )
        var mc : MediaController = MediaController(this)
        mc.setAnchorView(videoView)
        videoView.setMediaController(mc)


        button.setOnClickListener {
            var i : Intent
            i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }
    }
}