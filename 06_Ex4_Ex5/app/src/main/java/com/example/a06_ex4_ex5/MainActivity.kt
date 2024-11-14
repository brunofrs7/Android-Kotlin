package com.example.a06_ex4_ex5

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a06_ex4_ex5.databinding.ActivityMainBinding

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
        binding.buttonPedido.setOnClickListener {
            val i = Intent(this, SplashScreenActivity::class.java)
            i.putExtra("quant_cafe", binding.editQuantidadeCafe.text.toString())
            i.putExtra("quant_croissant", binding.editQuantidadeCroissant.text.toString())
            i.putExtra("quant_pao", binding.editQuantidadePao.text.toString())
            startActivity(i)
        }

        binding.checkCafe.setOnClickListener {
            if (binding.checkCafe.isChecked()) {
                binding.editQuantidadeCafe.setText("1");
                binding.textPrecoCafe.setText("1€");
                binding.textPrecoCafe.setVisibility(View.VISIBLE);
            } else {
                binding.textPrecoCafe.setVisibility(View.GONE);
                binding.editQuantidadeCafe.setText("0");
            }
        }
        binding.checkCroissant.setOnClickListener {
            if (binding.checkCroissant.isChecked()) {
                binding.editQuantidadeCroissant.setText("1");
                binding.textPrecoCroissant.setText("1.2€");
                binding.textPrecoCroissant.setVisibility(View.VISIBLE);
            } else {
                binding.textPrecoCroissant.setVisibility(View.GONE);
                binding.editQuantidadeCroissant.setText("0");
            }
        }
        binding.checkPao.setOnClickListener {
            if (binding.checkPao.isChecked()) {
                binding.editQuantidadePao.setText("1");
                binding.textPrecoPao.setText("0.5€");
                binding.textPrecoPao.setVisibility(View.VISIBLE);
            } else {
                binding.textPrecoPao.setVisibility(View.GONE);
                binding.editQuantidadePao.setText("0");
            }
        }

    }
}