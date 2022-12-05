package com.example.a07_listviewobjetos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a07_listviewobjetos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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