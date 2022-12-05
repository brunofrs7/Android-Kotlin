package com.example.a07_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a07_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var listaNomes = ArrayList<String>()
        listaNomes.add("Ana")
        listaNomes.add("João")
        listaNomes.add("Maria")
        listaNomes.add("Filipe")
        listaNomes.add("Carlos")
        listaNomes.add("Mariana")

        binding.listView.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNomes)

        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Olá ${listaNomes.get(i)}", Toast.LENGTH_SHORT).show()
        }
    }
}