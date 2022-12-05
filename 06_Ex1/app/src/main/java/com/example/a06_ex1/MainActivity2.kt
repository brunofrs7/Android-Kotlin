package com.example.a06_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

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