package com.example.a02_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a02_ex1.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConverter.setOnClickListener {
            val euros: Double = binding.editValorEuros.text.toString().toDouble()
            val dolares: Double = euros * 0.8

            binding.tvResultado.text = dolares.toString()
        }
    }
}