package com.example.a09_ex1

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a09_ex1.databinding.ActivityMainBinding

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
        val sharedPreferences = this.getSharedPreferences("username", Context.MODE_PRIVATE)
        val usernameSharedPreferences = sharedPreferences.getString("username", "").toString()

        binding.editUsername.setText(usernameSharedPreferences)

        binding.buttonEntrar.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()

            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.apply()

            if (username.trim() == "user" && password.trim() == "pass") {
                Toast.makeText(this, "Bem-vindo", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login inválido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}