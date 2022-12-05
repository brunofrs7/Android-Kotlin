package com.example.a06_ex3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a06_ex3.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var username = "user"
    private var password = "pass"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            var i = Intent(this, LoginActivity::class.java)
            i.putExtra("user", username)
            i.putExtra("pass", password)
            startActivity(i)
        }
        binding.buttonSobre.setOnClickListener {
            startActivity(Intent(this, SobreActivity::class.java))
        }
        binding.buttonRegisto.setOnClickListener {
            var i = Intent(this, RegistoActivity::class.java)
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