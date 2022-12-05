package com.example.a08_ex2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.a08_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPessoa = ArrayList<Pessoa>()
        listaPessoa.add(Pessoa(0.0, 0.0, "Pessoa 1", "Morada 1"))
        listaPessoa.add(Pessoa(10.0, 10.0, "Pessoa 2", "Morada 2"))
        listaPessoa.add(Pessoa(5.0, 5.0, "Pessoa 3", "Morada 3"))
        listaPessoa.add(Pessoa(10.0, 5.0, "Pessoa 4", "Morada 4"))

        binding.listView.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPessoa)

        binding.listView.setOnItemClickListener { adapterView, view, pos, l ->
            var i = Intent(this, MapsActivity::class.java)
            i.putExtra("latitude", listaPessoa.get(pos).latitude)
            i.putExtra("longitude", listaPessoa.get(pos).longitude)
            i.putExtra("titulo", listaPessoa.get(pos).titulo)
            startActivity(i)
        }
    }
}