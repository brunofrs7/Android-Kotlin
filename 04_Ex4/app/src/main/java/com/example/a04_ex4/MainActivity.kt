package com.example.a04_ex4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a04_ex4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEntrar.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()

            if (username.trim().equals("user") && password.trim().equals("pass"))
                Toast.makeText(applicationContext, "Login OK", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(applicationContext, "Login Errado", Toast.LENGTH_SHORT).show()

            binding.editUsername.text.clear()
            binding.editPassword.text.clear()

        }
    }
}