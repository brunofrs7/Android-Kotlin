package com.example.a05_ex4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a05_ex4.databinding.ActivityMainBinding
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonVerificar.setOnClickListener {
            val numero = binding.editNumero.text.toString().toInt()
            if (numero % 2 == 0) {
                binding.textPar.text = "${numero} é par"
            } else {
                binding.textPar.text = "${numero} é ímpar"
            }

            if (isPrime(numero)) {
                binding.textPrimo.text = "${numero} é primo"
            } else {
                binding.textPrimo.text = "${numero} não é primo"
            }
        }
    }

    private fun isPrime(num: Int): Boolean {
        if (num <= 1) return false

        for (i in 2..sqrt(num.toDouble()).toInt()) if (num % i == 0) return false
        return true
    }
}