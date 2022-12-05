package com.example.a02_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a02_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConverter.setOnClickListener {
            val euros: Double = binding.editValorEuros.text.toString().toDouble()
            //val dolares: Double = (euros * 0.80 * 100).roundToInt().toDouble() / 100;

            val dolares: Double = String.format("%.2f", euros * 0.8).toDouble()

            binding.textResultado.text = dolares.toString() + "$"
        }
    }
}