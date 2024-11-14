package com.example.a03_ex2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a03_ex2.databinding.ActivityMainBinding

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

        binding.buttonDizerOla.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val sobrenome = binding.editSobrenome.text.toString()

            if (!nome.trim().equals("") && !sobrenome.trim().equals("")) {
                //binding.tvResultado.text = "Olá ${nome} ${sobrenome}"
                //binding.tvResultado.text = "Olá "+ nome + " " +sobrenome

                Toast.makeText(applicationContext, "Olá ${nome} ${sobrenome}", Toast.LENGTH_SHORT)
                    .show()

            } else {
                binding.textResultado.text = "Pf preencha ambos os campos"
            }
        }
    }
}