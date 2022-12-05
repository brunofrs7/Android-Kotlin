package com.example.a06_intentextras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_intentextras.databinding.ActivityMain2Binding
import com.example.a06_intentextras.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        val nome = i.extras?.getString("nome")

        binding.textNome.text = "Olá ${nome}"
    }
}