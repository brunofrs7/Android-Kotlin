package com.example.a14_ex1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a14_ex1.databinding.ActivityMainBinding

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

        binding.buttonEntrar.setOnClickListener {
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
                val res = db.login(username, password)
                if (res > 0) {
                    val i = Intent(this, ContaActivity::class.java)
                    i.putExtra("id", res)
                    startActivity(i)
                } else {
                    Toast.makeText(this, "Login errado, tente novamente", Toast.LENGTH_SHORT)
                        .show()
                }
                binding.editUsername.setText("")
                binding.editPassword.setText("")
            }
        }

        binding.buttonRegistar.setOnClickListener {
            startActivity(Intent(this, RegistoActivity::class.java))
        }
    }
}