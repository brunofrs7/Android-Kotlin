package com.example.a14_ex1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a14_ex1.databinding.ActivityContaBinding

class ContaActivity : AppCompatActivity() {

    private val binding by lazy { ActivityContaBinding.inflate(layoutInflater) }

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
        val db = DBHelper(this)

        val id = i.getIntExtra("id", 0)
        val utilizador = db.select(id)

        if (utilizador != null) {
            binding.editUsername.setText(utilizador.username)
            binding.editPassword.setText(utilizador.password)
        }

        binding.buttonEditar.setOnClickListener {
            val res = db.mudarPassword(
                id, binding.editUsername.text.toString(), binding.editPassword.text.toString()
            )
            if (res > 0) {
                Toast.makeText(this, "Password alterada com sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Erro ao alterar password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonEliminar.setOnClickListener {
            val res = db.eliminarConta(id)
            if (res > 0) {
                Toast.makeText(this, "Conta eliminada com sucesso", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Erro ao eliminar conta", Toast.LENGTH_SHORT).show()

            }
        }
    }
}