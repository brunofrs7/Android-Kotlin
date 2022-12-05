package com.example.a06_ex4_ex5

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.a06_ex4_ex5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


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