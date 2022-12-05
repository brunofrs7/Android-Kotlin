package com.example.a09_ex2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a09_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("nota", Context.MODE_PRIVATE)
        val nota = sharedPreferences.getString("nota", "").toString()

        binding.textNotas.setText(nota)

        binding.textNotas.setOnClickListener {
            binding.editNotas.setText(binding.textNotas.text.toString())
        }

        binding.buttonGravar.setOnClickListener {
            val novaNota = binding.editNotas.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("nota", novaNota)
            editor.apply()
            binding.textNotas.setText(novaNota)
            Toast.makeText(this, "Nota atualizada com sucesso", Toast.LENGTH_SHORT).show()
        }
    }
}