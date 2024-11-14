package com.example.a06_ex4_ex5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a06_ex4_ex5.databinding.ActivityResumoPedidoBinding

class ResumoPedidoActivity : AppCompatActivity() {

    private val binding by lazy { ActivityResumoPedidoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val i = intent
        val quant_cafe = i.getStringExtra("quant_cafe").toString().toInt()
        val quant_croissant = i.getStringExtra("quant_croissant").toString().toInt()
        val quant_pao = i.getStringExtra("quant_pao").toString().toInt()

        val texto = "Resumo do pedido: \n" +
                "Café: ${quant_cafe} Preço: ${(quant_cafe * 1)}€\n" +
                "Croissant: ${quant_croissant} Preço: ${quant_croissant * 1.2}€\n" +
                "Pão: $quant_pao Preço: ${quant_pao * 0.5}€"

        binding.textResumo.setText(texto)
    }
}