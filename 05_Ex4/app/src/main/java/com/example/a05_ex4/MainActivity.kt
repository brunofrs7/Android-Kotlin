package com.example.a05_ex4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a05_ex4.databinding.ActivityMainBinding
import kotlin.math.sqrt

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
}

private fun isPrime(num: Int): Boolean {
    if (num <= 1) return false

    for (i in 2..sqrt(num.toDouble()).toInt()) if (num % i == 0) return false
    return true
}