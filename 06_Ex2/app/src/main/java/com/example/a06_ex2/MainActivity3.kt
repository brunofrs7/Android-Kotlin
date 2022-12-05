package com.example.a06_ex2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex2.databinding.ActivityMain2Binding
import com.example.a06_ex2.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        var i = intent

        val num1 = intent.getStringExtra("num1").toString().toInt()
        val num2 = intent.getStringExtra("num2").toString().toInt()

        val soma = num1 + num2
        val subt = num1 - num2
        val mult = num1 * num2
        val divi = num1 / num2

        binding.textResultado.text =
            "${num1} + ${num2} = ${soma}\n" +
                    "${num1} - ${num2} = ${subt}\n" +
                    "${num1} x ${num2} = ${mult}\n" +
                    "${num1} / ${num2} = ${divi}"


    }
}
