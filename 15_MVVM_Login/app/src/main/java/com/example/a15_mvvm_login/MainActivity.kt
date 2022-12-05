package com.example.a15_mvvm_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a15_mvvm_login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.login().observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Login OK", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Errado", Toast.LENGTH_SHORT).show()
            }
        })

        binding.buttonEntrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            viewModel.doLogin(email, password)
        }
    }
}

