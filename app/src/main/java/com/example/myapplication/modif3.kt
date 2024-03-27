package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class modif3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modif3)

        val enre3: Button = findViewById(R.id.button12)
        val textView30: TextView = findViewById(R.id.textView555)
        val editText: EditText = findViewById(R.id.editTextText444)

        // Récupérer la valeur de pourcentage30 de l'intent
        val pourcentage30 = intent.getIntExtra("pourcentage30", 0)

        // Utiliser la valeur pour mettre à jour le TextView
        textView30.text = "Montant: $pourcentage30"

        enre3.setOnClickListener {
            val enteredValue = editText.text.toString().toIntOrNull() ?: 0
            val updatedPourcentage30 = pourcentage30 - enteredValue

            if (updatedPourcentage30 >= 0) {
                // Pourcentage30 doesn't become negative
                val resultIntent = Intent()
                resultIntent.putExtra("updatedPourcentage30", updatedPourcentage30)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                // Display a message indicating "montant introuvable"
                editText.error = "Montant introuvable"
            }
        }
    }
}
