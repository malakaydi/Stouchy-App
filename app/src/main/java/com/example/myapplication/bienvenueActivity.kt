package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class bienvenueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bienvenu)


        val loginButton: Button = findViewById(R.id.button15)
        loginButton.setOnClickListener {
            val loginIntent = Intent(this@bienvenueActivity, loginn::class.java)
            startActivity(loginIntent)
        }

        val signupButton: Button = findViewById(R.id.button16)
        signupButton.setOnClickListener {
            val signupIntent = Intent(this@bienvenueActivity, signup::class.java)
            startActivity(signupIntent)
        }
    }
}