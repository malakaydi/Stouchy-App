package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class apropos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.apropos)

        val comprisButton: Button = findViewById(R.id.button100)
        comprisButton.setOnClickListener {
            // Rediriger vers la page d'introduction
            val comprisIntent = Intent(this@apropos, pageIntro::class.java)
            startActivity(comprisIntent)
        }
    }
}