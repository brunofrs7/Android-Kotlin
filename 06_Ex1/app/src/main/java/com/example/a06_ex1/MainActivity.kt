package com.example.a06_ex1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a06_ex1.databinding.ActivityMainBinding

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