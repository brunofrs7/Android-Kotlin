package com.example.a12_apprelogio

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.a12_apprelogio.databinding.ActivityFullscreenBinding

class FullscreenActivity : AppCompatActivity() {

    private val binding by lazy { ActivityFullscreenBinding.inflate(layoutInflater) }
    private var isChecked = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val bateriaReceiver: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent != null) {
                    val nivel: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                    //Toast.makeText(applicationContext, nivel.toString(), Toast.LENGTH_SHORT).show()
                    binding.textNivelBateria.text = "${nivel}%"
                }
            }
        }

        registerReceiver(bateriaReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))

        binding.checkNivelBateria.setOnClickListener {
            if (isChecked) {
                isChecked = false
                binding.checkNivelBateria.isChecked = false
                binding.textNivelBateria.visibility = View.GONE
            } else {
                isChecked = true
                binding.checkNivelBateria.isChecked = true
                binding.textNivelBateria.visibility = View.VISIBLE
            }
        }

        binding.layoutMenu.animate().translationY(500F)

        binding.imageViewPreferencias.setOnClickListener {
            binding.layoutMenu.visibility = View.VISIBLE
            binding.layoutMenu.animate().translationY(0F).setDuration(
                resources.getInteger(android.R.integer.config_mediumAnimTime)
                    .toLong()
            )
        }

        binding.imageViewFechar.setOnClickListener {
            binding.layoutMenu.animate().translationY(binding.layoutMenu.measuredHeight.toFloat())
                .setDuration(
                    resources.getInteger(android.R.integer.config_mediumAnimTime)
                        .toLong()
                )
        }
    }
}