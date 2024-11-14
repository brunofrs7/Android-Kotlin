package com.example.a06_ex3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a06_ex3.databinding.ActivityRegistoBinding

class RegistoActivity : AppCompatActivity() {

    private val binding by lazy { ActivityRegistoBinding.inflate(layoutInflater) }

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

        binding.buttonRegistar.setOnClickListener {
            i.putExtra("user", binding.editUsername.text.toString())
            i.putExtra("pass", binding.editPassword.text.toString())
            setResult(1, i)
            finish()
        }
    }
}