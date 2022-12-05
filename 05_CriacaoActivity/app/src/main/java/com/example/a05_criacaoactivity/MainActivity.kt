package com.example.a05_criacaoactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a05_criacaoactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonIr.setOnClickListener {
            /*val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)*/

            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}