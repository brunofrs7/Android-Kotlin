package com.example.a06_ex1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a06_ex1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }

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
        val telefone = i.getStringExtra("telefone")
        val email = i.getStringExtra("email")
        val genero = i.getStringExtra("genero")

        if (genero != null) {
            if (genero.trim().uppercase().equals("M")) {
                binding.textResultado.text =
                    "O ${nome} mora na ${morada}, tem o telefone ${telefone} e o email ${email}"
            } else {
                binding.textResultado.text =
                    "A ${nome} mora na ${morada}, tem o telefone ${telefone} e o email ${email}"

            }
        }
    }
}