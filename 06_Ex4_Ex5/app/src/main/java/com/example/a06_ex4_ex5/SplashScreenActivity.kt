package com.example.a06_ex4_ex5

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val i = intent
            val j = Intent(this, ResumoPedidoActivity::class.java)
            j.putExtras(i)
            startActivity(j)
        }, 4000)
    }
}