package com.example.a07_ex3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a07_ex3.databinding.ActivityDetalhesBinding

class DetalhesActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetalhesBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val i = intent
        val nome = i.getStringExtra("nome")
        val morada = i.getStringExtra("morada")
        val email = i.getStringExtra("email")
        binding.textDetalhes.text = "Nome: ${nome}\n" +
                "Morada: ${morada}\n" +
                "Email: ${email}"
    }
}