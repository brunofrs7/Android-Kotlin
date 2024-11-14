package com.example.a06_ex2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a06_ex2.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    private val binding by lazy { ActivityMain3Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var i = intent

        val num1 = i.getStringExtra("num1").toString().toInt()
        val num2 = i.getStringExtra("num2").toString().toInt()

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