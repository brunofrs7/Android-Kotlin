package com.example.a09_sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.set
import com.example.a09_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("chave", Context.MODE_PRIVATE)
        val valor = sharedPreferences.getString("chave", "").toString()

        binding.textValor.setText(valor)


        binding.buttonEditar.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("chave", binding.textValor.text.toString())
            editor.apply()
        }

    }
}