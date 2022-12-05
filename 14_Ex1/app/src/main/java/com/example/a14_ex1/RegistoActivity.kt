package com.example.a14_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a14_ex1.databinding.ActivityRegistoBinding

class RegistoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegistar.setOnClickListener {
            val db = DBHelper(this)
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()

            if (username.trim().equals("") || password.trim().equals("")) {
                Toast.makeText(
                    this,
                    "Insira username e password para continuar",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (db.registar(username, password) > 0) {
                    Toast.makeText(this, "Registo criado com sucesso", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Erro ao criar o registo", Toast.LENGTH_SHORT).show()
                    binding.editUsername.setText("")
                    binding.editPassword.setText("")
                }
            }
        }
    }
}