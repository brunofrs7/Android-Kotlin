package com.example.a03_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a03_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonDizerOla.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val sobrenome = binding.editSobrenome.text.toString()

            if (!nome.trim().equals("") && !sobrenome.trim().equals("")) {
                binding.textResultado.text = "Olá ${nome} ${sobrenome}"
                //binding.tvResultado.text = "Olá "+ nome + " " +sobrenome

            } else {
                binding.textResultado.text = "Pf preencha ambos os campos"
            }
        }
    }
}