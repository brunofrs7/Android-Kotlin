package com.example.a13_recyclerview.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a13_recyclerview.data.CarroMock
import com.example.a13_recyclerview.R
import com.example.a13_recyclerview.adapter.CarroListAdapter
import com.example.a13_recyclerview.databinding.ActivityMainBinding

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

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val mock = CarroMock()
        binding.recyclerView.adapter =
            CarroListAdapter(mock.listaCarros, CarroListAdapter.OnClickListener { carro ->
                Toast.makeText(this, carro.modelo, Toast.LENGTH_SHORT).show()
            })
    }
}