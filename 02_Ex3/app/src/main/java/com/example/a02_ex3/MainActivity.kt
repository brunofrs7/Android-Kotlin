package com.example.a02_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a02_ex3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConverter.setOnClickListener {
            val celsius = binding.editCelsius.text.toString().toDouble()
            val fahrenheit = celsius * 1.8 + 32

            binding.textFahrenheit.text = fahrenheit.toString()
        }
    }
}