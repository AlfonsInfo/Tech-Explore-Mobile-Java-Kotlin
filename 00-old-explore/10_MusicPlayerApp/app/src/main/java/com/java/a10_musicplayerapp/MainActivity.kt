package com.java.a10_musicplayerapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.postDelayed
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    //Widget
    private lateinit var titleApp : TextView
    private lateinit var titleSong : TextView
    private lateinit var timer : TextView
    private lateinit var btnPlay : Button
    private lateinit var btnForward : Button
    private lateinit var btnBackward : Button
    private lateinit var btnPause : Button
    private lateinit var seekBar: SeekBar

    //Media Player
    private lateinit var mediaPlayer: MediaPlayer
    //Handlers
    private lateinit var handler: Handler

    //Variables
    private var startTime = 0;
    private var forwardTime = 10000;
    private var backwardTime = 10000;
    private var finalTime = 0;

    companion object{
        var oneTymeOnly = 0;
    }

    private fun initializeWidget(){
        titleApp = findViewById(R.id.tvTitleApp)
        titleSong = findViewById(R.id.songTitle)
        timer = findViewById(R.id.timer)
        btnPlay = findViewById(R.id.buttonPlay)
        btnPause = findViewById(R.id.buttonPause)
        btnForward = findViewById(R.id.buttonForward)
        btnBackward = findViewById(R.id.buttonBackward)
        seekBar = findViewById(R.id.seekBar)
        seekBar.isClickable = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeWidget()
        handler = Handler()
        mediaPlayer = MediaPlayer.create(
            this,
            R.raw.thinking_out_loud
        )
        // Functionalities
        btnPlay.setOnClickListener {
            playMusic()
        }
        btnPause.setOnClickListener {
            mediaPlayer.pause()
        }
        btnForward.setOnClickListener {
           forwardAction()
        }
        btnBackward.setOnClickListener {
            backwardAction()
        }
    }

    private fun playMusic(){
        mediaPlayer.start()

        finalTime = mediaPlayer.duration
        startTime = mediaPlayer.currentPosition

        if (oneTymeOnly == 0){
            seekBar.max = finalTime
            oneTymeOnly = 1
        }

        timer.text = String.format(
            "%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(finalTime.toDouble().toLong()),
            TimeUnit.MILLISECONDS.toSeconds(finalTime.toDouble().toLong()) % 60
        )

        seekBar.setProgress(startTime)
        handler.postDelayed(UpdateSongTime, 100)
    }


    private var UpdateSongTime : Runnable =  object : Runnable {
        override fun run() {
            startTime = mediaPlayer.currentPosition
            timer.setText(String.format(
                "%d min %d sec", TimeUnit.MILLISECONDS.toMinutes(startTime.toDouble().toLong()),
                TimeUnit.MILLISECONDS.toSeconds(startTime.toDouble().toLong()) % 60
            ))

            seekBar.setProgress(startTime)
            handler.postDelayed(this, 100)
        }
    }


    private fun forwardAction(){
        var temp : Int
        temp = startTime
        if(temp + forwardTime <= finalTime){
            startTime = startTime + forwardTime
            mediaPlayer.seekTo(startTime)
        }else{
            Toast.makeText(this,"Can't Jump Forward", Toast.LENGTH_SHORT).show()
        }
    }

    private fun backwardAction(){
        var temp : Int
        temp = startTime
        if(temp - backwardTime > 0){
            startTime = startTime - backwardTime
            mediaPlayer.seekTo(startTime)
        }else{
            Toast.makeText(this,"Can't Jump Backward", Toast.LENGTH_SHORT).show()
        }
    }

}