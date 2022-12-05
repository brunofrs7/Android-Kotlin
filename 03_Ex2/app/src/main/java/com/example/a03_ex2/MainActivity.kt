package com.example.a03_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a03_ex2.databinding.ActivityMainBinding

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
                //binding.tvResultado.text = "Olá ${nome} ${sobrenome}"
                //binding.tvResultado.text = "Olá "+ nome + " " +sobrenome

                Toast.makeText(applicationContext, "Olá ${nome} ${sobrenome}", Toast.LENGTH_SHORT).show()

            } else {
                binding.textResultado.text = "Pf preencha ambos os campos"
            }
        }
    }
}