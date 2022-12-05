package com.example.a14_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a14_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHelper(this)

        var pos = -1
        val listaAluno = db.selectAll()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAluno)
        binding.listView.adapter = adapter

        binding.textContador.setText("Existem ${listaAluno.size} alunos")

        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
            binding.editNome.setText(listaAluno.get(i).nome)
            binding.editEmail.setText(listaAluno.get(i).email)
            pos = i
        }

        binding.buttonInserir.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val email = binding.editEmail.text.toString()
            if (nome.trim().equals("") || email.trim().equals("")) {
                Toast.makeText(this, "Preencha nome e email para inserir", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val res = db.insert(nome, email)
                if (res > 0) {
                    listaAluno.add(Aluno(res.toInt(), nome, email))
                    Toast.makeText(this, "Aluno criado com sucesso", Toast.LENGTH_SHORT).show()
                    binding.textContador.setText("Existem ${listaAluno.size} alunos")
                } else {
                    Toast.makeText(this, "Erro ao criar aluno", Toast.LENGTH_SHORT).show()
                }
                adapter.notifyDataSetChanged()
            }
        }
        binding.buttonEditar.setOnClickListener {
            if (pos >= 0) {
                val id = listaAluno.get(pos).id
                val nome = binding.editNome.text.toString()
                val email = binding.editEmail.text.toString()
                if (nome.trim().equals("") || email.trim().equals("")) {
                    Toast.makeText(this, "Preencha nome e email para editar", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val res = db.update(id, nome, email)
                    if (res > 0) {
                        listaAluno.get(pos).nome = nome
                        listaAluno.get(pos).email = email
                        Toast.makeText(this, "Aluno editado com sucesso", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Erro ao editar aluno", Toast.LENGTH_SHORT).show()
                    }
                    adapter.notifyDataSetChanged()
                }
            } else {
                Toast.makeText(this, "Selecione um aluno para editar", Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonEliminar.setOnClickListener {
            if (pos >= 0) {
                val id = listaAluno.get(pos).id
                val res = db.delete(id)
                if (res > 0) {
                    listaAluno.removeAt(pos)
                    Toast.makeText(this, "Aluno editado com sucesso", Toast.LENGTH_SHORT).show()
                    binding.textContador.setText("Existem ${listaAluno.size} alunos")
                } else {
                    Toast.makeText(this, "Erro ao editar aluno", Toast.LENGTH_SHORT).show()
                }
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Selecione um aluno para editar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}