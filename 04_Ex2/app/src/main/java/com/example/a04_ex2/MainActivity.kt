package com.example.a04_ex2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonConverter.setOnClickListener {
            val euros: Double = binding.etValorEuros.text.toString().toDouble()
            //val dolares: Double = (euros * 0.80 * 100).roundToInt().toDouble() / 100;

            val dolares: Double = String.format("%.2f", euros * 0.8).toDouble()

            binding.textValorDolares.text = dolares.toString() + "$"
        }
    }
}