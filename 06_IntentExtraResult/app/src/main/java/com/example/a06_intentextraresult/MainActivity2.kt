package com.example.a06_intentextraresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.set
import com.example.a06_intentextraresult.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        binding.editNome.setText(i.getStringExtra("nome"))

        binding.buttonMudarOk.setOnClickListener {
            i.putExtra("nome", binding.editNome.text.toString())
            setResult(1, i)
            finish()
        }

    }
}