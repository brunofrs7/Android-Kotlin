package com.example.a06_ex3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a06_ex3.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var username = "user"
    private var password = "pass"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.buttonLogin.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            i.putExtra("user", username)
            i.putExtra("pass", password)
            startActivity(i)
        }
        binding.buttonSobre.setOnClickListener {
            startActivity(Intent(this, SobreActivity::class.java))
        }
        binding.buttonRegisto.setOnClickListener {
            val i = Intent(this, RegistoActivity::class.java)
            i.putExtra("user", username)
            i.putExtra("pass", password)
            resultLauncher.launch(i)
        }

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.data != null) {
                    if (it.resultCode == 1) {
                        username = it.data?.getStringExtra("user").toString()
                        password = it.data?.getStringExtra("pass").toString()
                    }
                }
            }
    }
}