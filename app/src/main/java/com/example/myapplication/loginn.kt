package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class loginn : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginn)

        editTextEmail = findViewById(R.id.editTextPersonName)
        editTextPassword = findViewById(R.id.editTextPassword)

        val loginnButton: ImageView = findViewById(R.id.imageView24)
        loginnButton.setOnClickListener {
            if (areFieldsValid()) {
                val loginnIntent = Intent(this@loginn, pageIntro::class.java)
                startActivity(loginnIntent)
            }
        }

        val loginGButton: Button = findViewById(R.id.button20)
        loginGButton.setOnClickListener {
            val loginGIntent = Intent(this@loginn, pageIntro::class.java)
            startActivity(loginGIntent)
        }

        val loginFButton: Button = findViewById(R.id.button21)
        loginFButton.setOnClickListener {
            val loginFIntent = Intent(this@loginn, pageIntro::class.java)
            startActivity(loginFIntent)
        }


        val textViewButton: TextView = findViewById(R.id.textView18)
        textViewButton.setOnClickListener {
            val textViewIntent = Intent(this@loginn, signup::class.java)
            startActivity(textViewIntent)
        }
    }

    private fun areFieldsValid(): Boolean {
        val email = editTextEmail.text.toString().trim()
        val password = editTextPassword.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {

            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            return false
        }

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString("email", "")
        val savedPassword = sharedPreferences.getString("password", "")
        val savedName = sharedPreferences.getString("name", "")


        if (email != savedEmail || password != savedPassword) {
            Toast.makeText(this, "Les coordonnées ne correspondent pas", Toast.LENGTH_SHORT).show()
            return false
        }

        val welcomeMessage = "Bienvenue, $savedName !"
        Toast.makeText(this, welcomeMessage, Toast.LENGTH_SHORT).show()

        return true
    }
}



