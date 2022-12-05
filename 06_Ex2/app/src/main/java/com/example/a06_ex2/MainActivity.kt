package com.example.a06_ex2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex2.databinding.ActivityMain2Binding
import com.example.a06_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPrimeiro.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("num1", binding.editPrimeiroNumero.text.toString())
            startActivity(i)
        }
    }
}