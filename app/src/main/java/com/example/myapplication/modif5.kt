package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class modif5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modif5)

        val enre5: Button = findViewById(R.id.button14)
        val textView50: TextView = findViewById(R.id.textView55555)
        val editText: EditText = findViewById(R.id.editTextText44444)

        // Récupérer la valeur de pourcentage40 de l'intent
        val pourcentage40 = intent.getIntExtra("pourcentage40", 0)

        // Utiliser la valeur pour mettre à jour le TextView
        textView50.text = "Montant: $pourcentage40"

        enre5.setOnClickListener {
            val enteredValue = editText.text.toString().toIntOrNull() ?: 0
            val updatedPourcentage40 = pourcentage40 - enteredValue

            if (updatedPourcentage40 >= 0) {
                // Pourcentage40 doesn't become negative
                val resultIntent = Intent()
                resultIntent.putExtra("updatedPourcentage40", updatedPourcentage40)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                // Display a message indicating "montant introuvable"
                editText.error = "Montant introuvable"
            }
        }
    }
}
