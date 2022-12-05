package com.example.a05_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a05_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonUm.setOnClickListener {
            Toast.makeText(applicationContext, "Clicado", Toast.LENGTH_SHORT).show()
        }
        binding.buttonDois.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}