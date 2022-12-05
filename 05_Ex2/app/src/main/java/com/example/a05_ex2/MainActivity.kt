package com.example.a05_ex2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a05_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEntrar.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()

            if (username.trim().equals("user") && password.trim().equals("pass")) {
                startActivity(Intent(this, LoginOkActivity::class.java))
            } else {
                startActivity(Intent(this, LoginErradoActivity::class.java))
            }
        }
    }
}