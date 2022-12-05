package com.example.a13_recyclerview.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a13_recyclerview.adapter.CarroListAdapter
import com.example.a13_recyclerview.data.CarroMock
import com.example.a13_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val mock = CarroMock()
        binding.recyclerView.adapter =
            CarroListAdapter(mock.listaCarros, CarroListAdapter.OnClickListener { carro ->
                Toast.makeText(this, carro.modelo, Toast.LENGTH_SHORT).show()
            })
    }
}