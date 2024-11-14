package com.example.a16_room

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a16_room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    private val adapter by lazy { UserAdapter() }
    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.recyclerUsers.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerUsers.adapter = adapter

        val listener = object : UserAdapter.OnUserListener {
            override fun OnClick(id: Int) {
                Toast.makeText(applicationContext, id.toString(), Toast.LENGTH_SHORT).show()
                viewModel.get(id)
            }
        }
        adapter.attachListener(listener)

        binding.buttonInsert.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()
            viewModel.insert(username, password)
        }
        binding.buttonEdit.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editUsername.text.toString()
            viewModel.update(id, username, password)
        }
        binding.buttonDelete.setOnClickListener {
            viewModel.delete(id)
        }

        observe()
        viewModel.getAll()
    }

    private fun observe() {
        viewModel.users.observe(this) {
            adapter.updateUsers(it)
        }
        viewModel.user.observe(this) {
            id = it.id
            binding.textId.text = id.toString()
            binding.editUsername.setText(it.username)
            binding.editPassword.setText(it.password)
        }
        viewModel.newChange.observe(this) {
            viewModel.getAll()
        }
    }
}