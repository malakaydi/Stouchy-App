package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class signup : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextConfirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        editTextName = findViewById(R.id.editTextPersonName2)
        editTextEmail = findViewById(R.id.editTextPersonName)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextConfirmPassword = findViewById(R.id.editTextPassword2)


        val signupGButton: Button = findViewById(R.id.button20)
        signupGButton.setOnClickListener {
            val signupGIntent = Intent(this@signup, pageIntro::class.java)
            startActivity(signupGIntent)
        }

        val signupFButton: Button = findViewById(R.id.button21)
        signupFButton.setOnClickListener {
            val signupFIntent = Intent(this@signup, pageIntro::class.java)
            startActivity(signupFIntent)
        }

        val textViewButton: TextView = findViewById(R.id.textView18)
        textViewButton.setOnClickListener {
            val textViewIntent = Intent(this@signup, loginn::class.java)
            startActivity(textViewIntent)
        }


        val signupButton: ImageView = findViewById(R.id.imageView24)
        signupButton.setOnClickListener {
            if (areFieldsValid()) {
                val signupIntent = Intent(this@signup, loginn::class.java)
                startActivity(signupIntent)
            }
        }
    }

    private fun areFieldsValid(): Boolean {
        val name = editTextName.text.toString().trim() //supprimer les espaces blancs au début et à la fin d'une chaîne de caractères
        val email = editTextEmail.text.toString().trim()
        val password = editTextPassword.text.toString().trim()
        val confirmPassword = editTextConfirmPassword.text.toString().trim()

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            return false
        }

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]"
        if (!email.matches(emailPattern.toRegex())) {
            Toast.makeText(this, "Veuillez entrer une adresse email valide", Toast.LENGTH_SHORT)
                .show()
            return false
        }

        if (password.length < 8 || !containsLetterAndDigit(password)) {
            Toast.makeText(
                this,
                "Le mot de passe doit contenir au moins 8 caractères, y compris des lettres et des chiffres",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }


        if (password != confirmPassword) {
            Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT)
                .show()
            return false
        }


        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("email", email)
        editor.putString("password", password)
        editor.putString("name", name)
        editor.apply()

        return true
    }

    private fun containsLetterAndDigit(password: String): Boolean {
        var hasLetter = false
        var hasDigit = false

        for (char in password) {
            if (char.isLetter()) {
                hasLetter = true
            } else if (char.isDigit()) {
                hasDigit = true
            }
        }

        return hasLetter && hasDigit
    }
}

