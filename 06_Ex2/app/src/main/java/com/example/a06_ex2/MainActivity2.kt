package com.example.a06_ex2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.a06_ex2.databinding.ActivityMain2Binding
import com.example.a06_ex2.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSegundo.setOnClickListener {
            var i = intent
            val extras = i.extras

            i = Intent(this, MainActivity3::class.java)
            if (extras != null) {
                i.putExtras(extras)
            }
            i.putExtra("num2", binding.editSegundoNumero.text.toString())
            startActivity(i)
        }
    }
}