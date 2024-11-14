package com.example.a07_listviewint

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a07_listviewint.databinding.ActivityMainBinding

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
        val listaNumeros = ArrayList<Int>()

        listaNumeros.add(1)
        listaNumeros.add(10)
        listaNumeros.add(5)
        listaNumeros.add(4)
        listaNumeros.add(8)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNumeros)
        binding.listView.adapter = arrayAdapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Clicado em ${listaNumeros.get(position)}", Toast.LENGTH_SHORT)
                .show()
        }
    }
}