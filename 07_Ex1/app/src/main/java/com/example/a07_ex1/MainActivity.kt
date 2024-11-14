package com.example.a07_ex1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a07_ex1.databinding.ActivityMainBinding

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

        val listaNomes = ArrayList<String>()
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