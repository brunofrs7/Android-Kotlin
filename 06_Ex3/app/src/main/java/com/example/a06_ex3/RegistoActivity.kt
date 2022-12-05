package com.example.a06_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex3.databinding.ActivityRegistoBinding

class RegistoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var i = intent

        binding.buttonRegistar.setOnClickListener {
            i.putExtra("user", binding.editUsername.text.toString())
            i.putExtra("pass", binding.editPassword.text.toString())
            setResult(1,i)
            finish()
        }
    }
}