package com.example.a09_ex1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a09_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("username", Context.MODE_PRIVATE)
        val usernameSharedPreferences = sharedPreferences.getString("username", "").toString()

        binding.editUsername.setText(usernameSharedPreferences)

        binding.buttonEntrar.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()

            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.apply()

            if (username.trim().equals("user") && password.trim().equals("pass")) {
                Toast.makeText(this, "Bem-vindo", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login inválido", Toast.LENGTH_SHORT).show()

            }
        }
    }
}