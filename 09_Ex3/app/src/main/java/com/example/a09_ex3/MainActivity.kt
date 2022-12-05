package com.example.a09_ex3

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaPlayer = MediaPlayer.create(this, R.raw.catbell)
        mediaPlayer.start()
    }
}