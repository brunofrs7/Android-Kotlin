package com.example.a07_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.a07_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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