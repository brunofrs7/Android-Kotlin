package com.example.a07_listviewobjetos

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a07_listviewobjetos.databinding.ActivityMainBinding

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
        val listaUtilizadores = ArrayList<Utilizador>()

        listaUtilizadores.add(Utilizador("username", "password"))
        listaUtilizadores.add(Utilizador("user1", "pass1"))
        listaUtilizadores.add(Utilizador("user", "pass"))
        listaUtilizadores.add(Utilizador("admin", "pwd123"))

        binding.listView.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listaUtilizadores)

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, listaUtilizadores.get(position).password, Toast.LENGTH_SHORT)
                .show()
        }
    }
}