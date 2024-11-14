package com.example.a09_ex2

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a09_ex2.databinding.ActivityMainBinding

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

        val sharedPreferences = this.getSharedPreferences("nota", Context.MODE_PRIVATE)
        val nota = sharedPreferences.getString("nota", "").toString()

        binding.textNotas.text = nota

        binding.textNotas.setOnClickListener {
            binding.editNotas.setText(binding.textNotas.text.toString())
        }

        binding.buttonGravar.setOnClickListener {
            val novaNota = binding.editNotas.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("nota", novaNota)
            editor.apply()
            binding.textNotas.text = novaNota
            Toast.makeText(this, "Nota atualizada com sucesso", Toast.LENGTH_SHORT).show()
        }
    }
}