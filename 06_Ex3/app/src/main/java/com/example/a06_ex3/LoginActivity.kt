package com.example.a06_ex3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a06_ex3.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val i = intent

        val user = i.getStringExtra("user")
        val pass = i.getStringExtra("pass")

        binding.buttonEntrar.setOnClickListener {
            if (user != null && pass != null) {
                if (user == binding.editUsername.text.toString() && pass == binding.editPassword.text.toString()) {
                    startActivity(Intent(this, SobreActivity::class.java))
                } else {
                    Toast.makeText(this, "Login errado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}