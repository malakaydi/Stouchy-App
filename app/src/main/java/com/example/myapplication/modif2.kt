package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class modif2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modif2)

        val enre2: Button = findViewById(R.id.button11)
        val textView20: TextView = findViewById(R.id.textView55)
        val editText: EditText = findViewById(R.id.editTextText44)

        // Récupérer la valeur de pourcentage10 de l'intent
        val pourcentage10 = intent.getIntExtra("pourcentage10", 0)

        // Utiliser la valeur pour mettre à jour le TextView
        textView20.text = "Montant: $pourcentage10"

        enre2.setOnClickListener {
            val enteredValue = editText.text.toString().toIntOrNull() ?: 0
            val updatedPourcentage10 = pourcentage10 - enteredValue

            if (updatedPourcentage10 >= 0) {
                // Pourcentage10 doesn't become negative
                val resultIntent = Intent()
                resultIntent.putExtra("updatedPourcentage10", updatedPourcentage10)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                // Display a message indicating "montant introuvable"
                editText.error = "Montant introuvable"
            }
        }
    }
}
