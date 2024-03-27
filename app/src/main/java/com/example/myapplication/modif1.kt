package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class modif1 : AppCompatActivity() {
    private var pourcentage20: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modif1)

        val pourcentage20 = intent.getIntExtra("pourcentage20", 0)

        val enre1: Button = findViewById(R.id.button10)
        val textView5: TextView = findViewById(R.id.textView5)
        val editText: EditText = findViewById(R.id.editTextText4)

        textView5.text = "Montant: $pourcentage20"

        enre1.setOnClickListener {
            val enteredValue = editText.text.toString().toIntOrNull() ?: 0
            val updatedPourcentage20 = pourcentage20 - enteredValue

            if (updatedPourcentage20 >= 0) {
                // Pourcentage20 doesn't become negative
                val resultIntent = Intent()
                resultIntent.putExtra("updatedPourcentage20", updatedPourcentage20)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                // Display a message indicating "montant introuvable"
                editText.error = "Montant introuvable"
            }
        }
    }
}
