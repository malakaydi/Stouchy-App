package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var editSalaire: EditText
    private lateinit var editMontant: EditText
    private lateinit var editSemaine: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val spinner: Spinner = findViewById(R.id.spinner10)
        val deviseList = resources.getStringArray(R.array.devise_list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, deviseList)

        val spinnerDuree: Spinner = findViewById(R.id.spinner3)
        val dureeList = resources.getStringArray(R.array.duree)
        val adapterDuree = ArrayAdapter(this, android.R.layout.simple_spinner_item, dureeList)

        adapterDuree.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDuree.adapter = adapterDuree
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        editSalaire = findViewById(R.id.editTextText)
        editMontant = findViewById(R.id.editTextText3)
        editSemaine = findViewById(R.id.editTextText2)

        val btnContinuer: Button = findViewById(R.id.button)

        btnContinuer.setOnClickListener {
            if (champsObligatoiresRemplis()) {
                val intent = Intent(this@MainActivity2, calcul::class.java)
                intent.putExtra("salaire", editSalaire.text.toString())
                intent.putExtra("montant", editMontant.text.toString())
                intent.putExtra("semaine", editSemaine.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity2, "Veuillez remplir tous les champs obligatoires", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun champsObligatoiresRemplis(): Boolean {
        val salaire = editSalaire.text.toString()
        val montant = editMontant.text.toString()
        val semaine = editSemaine.text.toString()

        if (salaire.isNotEmpty() && montant.isNotEmpty() && semaine.isNotEmpty()) {
            val salaireInt = salaire.toInt()
            val montantInt = montant.toInt()
            val semaineInt = semaine.toInt()

            // Assurez-vous que le montant à sauvegarder est inférieur ou égal au salaire
            if ((montantInt ) <= (salaireInt * semaineInt)) {
                return true
            } else {
                Toast.makeText(this@MainActivity2, "Le montant à sauvegarder doit être inférieur ou égal au salaire", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this@MainActivity2, "Veuillez remplir tous les champs obligatoires", Toast.LENGTH_SHORT).show()
        }

        return false
    }
}
