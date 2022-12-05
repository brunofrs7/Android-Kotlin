package com.example.a07_ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.a07_ex3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaAlunos = ArrayList<Aluno>()

        listaAlunos.add(Aluno("Maria", "Rua 123", "maria@email.pt"))
        listaAlunos.add(Aluno("José", "Rua 321", "jose@email.pt"))
        listaAlunos.add(Aluno("Carolina", "Rua 111", "carolina@email.pt"))

        binding.listView.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAlunos)

        binding.listView.setOnItemClickListener { adapterView, view, pos, l ->
            val i = Intent(this, DetalhesActivity::class.java)
            i.putExtra("nome", listaAlunos.get(pos).nome)
            i.putExtra("morada", listaAlunos.get(pos).morada)
            i.putExtra("email", listaAlunos.get(pos).email)
            startActivity(i)
        }
    }
}