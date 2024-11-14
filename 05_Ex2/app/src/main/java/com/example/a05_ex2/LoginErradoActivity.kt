package com.example.a05_ex2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a05_ex2.databinding.ActivityLoginErradoBinding

class LoginErradoActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginErradoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Toast.makeText(applicationContext, "Login errado, tente novamente", Toast.LENGTH_SHORT)
            .show()

        binding.buttonVoltar.setOnClickListener {
            finish()
        }
    }
}