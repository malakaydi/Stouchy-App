package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class modif4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modif4)

        val enre4: Button = findViewById(R.id.button13)
        val textView40: TextView = findViewById(R.id.textView5555)
        val editText: EditText = findViewById(R.id.editTextText4444)

        // Récupérer la valeur de pourcentage50 de l'intent
        val pourcentage50 = intent.getIntExtra("pourcentage50", 0)

        // Utiliser la valeur pour mettre à jour le TextView
        textView40.text = "Montant: $pourcentage50"

        enre4.setOnClickListener {
            val enteredValue = editText.text.toString().toIntOrNull() ?: 0
            val updatedPourcentage50 = pourcentage50 - enteredValue

            if (updatedPourcentage50 >= 0) {
                // Pourcentage50 doesn't become negative
                val resultIntent = Intent()
                resultIntent.putExtra("updatedPourcentage50", updatedPourcentage50)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                // Display a message indicating "montant introuvable"
                editText.error = "Montant introuvable"
            }
        }
    }
}
