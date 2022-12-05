package com.example.a05_ex5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a05_ex5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener {
            val total = binding.editTotalDias.text.toString().toInt()

            val anos = total / 365
            val semanas = total % 365 / 7
            val dias = total % 365 % 7

            binding.textResultado.text="${total} dias são ${anos} anos, ${semanas} semanas e ${dias} dias"
        }
    }
}