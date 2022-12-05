package com.example.a06_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOk.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("nome", binding.editNome.text.toString())
            i.putExtra("morada", binding.editMorada.text.toString())
            i.putExtra("telefone", binding.editTelefone.text.toString())
            i.putExtra("email", binding.editEmail.text.toString())
            i.putExtra("genero", binding.editGenero.text.toString())
            startActivity(i)
        }
    }
}