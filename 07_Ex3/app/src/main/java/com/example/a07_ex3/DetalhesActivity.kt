package com.example.a07_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a07_ex3.databinding.ActivityDetalhesBinding
import com.example.a07_ex3.databinding.ActivityMainBinding

class DetalhesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val nome = i.getStringExtra("nome")
        val morada = i.getStringExtra("morada")
        val email = i.getStringExtra("email")
        binding.textDetalhes.text = "Nome: ${nome}\n" +
                "Morada: ${morada}\n" +
                "Email: ${email}"

    }
}