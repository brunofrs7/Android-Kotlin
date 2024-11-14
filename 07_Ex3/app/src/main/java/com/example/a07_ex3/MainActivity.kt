package com.example.a07_ex3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a07_ex3.databinding.ActivityMainBinding

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