package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString("email", "")
        val savedPassword = sharedPreferences.getString("password", "")
        val savedName = sharedPreferences.getString("name", "")

        // Maintenant, vous avez les données, vous pouvez les afficher où vous en avez besoin dans votre layout (XML).
        // Exemple : supposons que vous ayez des TextView dans votre layout avec les IDs suivants :
        val emailTextView: TextView = findViewById(R.id.emailTextView)
        val passwordTextView: TextView = findViewById(R.id.passwordTextView)
        val nameTextView: TextView = findViewById(R.id.nameTextView)

        // Mettez à jour le texte des TextView avec les données récupérées
        emailTextView.text = "Email: $savedEmail"
        passwordTextView.text = "Password: $savedPassword"
        nameTextView.text = "Name: $savedName"


        val okButton: Button = findViewById(R.id.button100)
        okButton.setOnClickListener {
            val okIntent = Intent(this@profile, pageIntro::class.java)
            startActivity(okIntent)
        }
    }
}
