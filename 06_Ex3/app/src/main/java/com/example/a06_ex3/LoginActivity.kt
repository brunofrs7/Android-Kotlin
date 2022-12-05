package com.example.a06_ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a06_ex3.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var i = intent

        val user = i.getStringExtra("user")
        val pass = i.getStringExtra("pass")

        binding.buttonEntrar.setOnClickListener {
            if (user != null && pass != null) {
                if (user.equals(binding.editUsername.text.toString()) && pass.equals(binding.editPassword.text.toString())) {
                    startActivity(Intent(this, SobreActivity::class.java))
                } else {
                    Toast.makeText(this, "Login errado", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}