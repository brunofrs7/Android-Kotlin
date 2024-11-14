package com.example.a07_ex2

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a07_ex2.databinding.ActivityMainBinding

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
        listaNumeros.add(10)
        listaNumeros.add(15)
        listaNumeros.add(20)
        listaNumeros.add(30)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNumeros)
        binding.listView.adapter = adapter


        binding.buttonInserir.setOnClickListener {
            if (!binding.editNumero.text.toString().trim().isEmpty()) {
                listaNumeros.add(binding.editNumero.text.toString().toInt())
                adapter.notifyDataSetChanged()
            }
        }
    }
}