package com.example.a14_basedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.a14_basedados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHelper(this)

        val listaUtilizadores = db.utilizadorListSelectAll()

        binding.listView.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listaUtilizadores)

    }
}