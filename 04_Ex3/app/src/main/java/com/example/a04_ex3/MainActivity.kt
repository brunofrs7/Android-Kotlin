package com.example.a04_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a04_ex3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDolar.setOnClickListener {
            val euros = binding.editValorEuros.text.toString().toDouble()
            val dolares: Double = String.format("%.2f", euros * 4.4).toDouble()

            Toast.makeText(applicationContext, "Dolares: $${dolares}", Toast.LENGTH_SHORT).show()
        }
        binding.buttonReal.setOnClickListener {
            val euros = binding.editValorEuros.text.toString().toDouble()
            val real: Double = String.format("%.2f", euros * 1.2).toDouble()

            Toast.makeText(applicationContext, "Reais: R$${real}", Toast.LENGTH_SHORT).show()
        }
        binding.buttonPeso.setOnClickListener {
            val euros = binding.editValorEuros.text.toString().toDouble()
            val peso: Double = String.format("%.2f", euros * 31.5).toDouble()

            Toast.makeText(applicationContext, "Pesos: MX$${peso}", Toast.LENGTH_SHORT).show()
        }
    }
}