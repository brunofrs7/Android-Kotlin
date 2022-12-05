package com.example.a14_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a14_ex1.databinding.ActivityContaBinding

class ContaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContaBinding.inflate(layoutInflater)
        setContentView(binding.root)

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