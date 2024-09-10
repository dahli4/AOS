package com.example.andriod05

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var tvHello: TextView = findViewById(R.id.tvHello)
        var btnHello: Button = findViewById(R.id.btnHello)

        btnHello.setOnClickListener {
            tvHello.setText("haha")
        }
    }
}