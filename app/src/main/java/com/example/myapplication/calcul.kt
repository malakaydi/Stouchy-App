package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class calcul : AppCompatActivity() {
    private var pourcentage10: Int = 0
    private var pourcentage20: Int = 0
    private var pourcentage40: Int = 0
    private var pourcentage30: Int = 0
    private var pourcentage50: Int = 0
    private lateinit var textView4: TextView

    private val MODIF1_REQUEST_CODE = 1
    private val MODIF2_REQUEST_CODE = 2
    private val MODIF3_REQUEST_CODE = 3
    private val MODIF4_REQUEST_CODE = 4
    private val MODIF5_REQUEST_CODE = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calcul)

        textView4 = findViewById(R.id.textView4)

        // Récupérer les valeurs nécessaires de l'intent
        val salaireString = intent.getStringExtra("salaire")
        val montantString = intent.getStringExtra("montant")
        val semaineString = intent.getStringExtra("semaine")
        val resultatString = intent.getStringExtra("resultat")

        // Convertir les valeurs en entiers
        val salaireInt = salaireString?.toIntOrNull() ?: 0
        val montantInt = montantString?.toIntOrNull() ?: 0
        val semaineInt = semaineString?.toIntOrNull() ?: 1
        val resultatInt = resultatString?.toIntOrNull() ?: 0

        val resultat = ((salaireInt * semaineInt) - montantInt) / semaineInt

        // Calculer les pourcentages
        pourcentage20 = (resultat * 0.20).toInt()
        pourcentage30 = (resultat * 0.30).toInt()
        pourcentage40 = (resultat * 0.30).toInt()
        pourcentage10 = (resultat * 0.10).toInt()
        pourcentage50 = (resultat * 0.10).toInt()

        // Modifier le texte du TextView avec le résultat
        textView4.text = "Montant: $resultat Dnt"

        // Mettre à jour les valeurs des TextView avec les pourcentages
        val textView8: TextView = findViewById(R.id.textView8)
        val textView9: TextView = findViewById(R.id.textView9)
        val textView10: TextView = findViewById(R.id.textView10)
        val textView11: TextView = findViewById(R.id.textView11)
        val textView12: TextView = findViewById(R.id.textView12)

        textView8.text = "Education: ${pourcentage20}Dnt"
        textView9.text = "Santé :    ${pourcentage10}Dnt"
        textView10.text = "Alimentation: ${pourcentage30}Dnt"
        textView11.text = "Transport: ${pourcentage50}Dnt"
        textView12.text = "Autre: ${pourcentage40}Dnt"

        val modi1: Button = findViewById(R.id.button5)
        val modi2: Button = findViewById(R.id.button6)
        val modi3: Button = findViewById(R.id.button7)
        val modi4: Button = findViewById(R.id.button8)
        val modi5: Button = findViewById(R.id.button9)
        val button35: Button = findViewById(R.id.button35)
        val button17: Button = findViewById(R.id.button17)
        val button18: Button = findViewById(R.id.button18)
        val button19: Button = findViewById(R.id.button19)
        val button22: Button = findViewById(R.id.button22)
        val button23: Button = findViewById(R.id.button23)
        val button24: Button = findViewById(R.id.button24)
        val button25: Button = findViewById(R.id.button25)

        modi1.setOnClickListener {
            val modi1Intent = Intent(this@calcul, modif1::class.java)
            modi1Intent.putExtra("pourcentage20", pourcentage20)
            startActivityForResult(modi1Intent, MODIF1_REQUEST_CODE)
        }

        modi2.setOnClickListener {
            val modi2Intent = Intent(this@calcul, modif2::class.java)
            modi2Intent.putExtra("pourcentage10", pourcentage10)
            startActivityForResult(modi2Intent, MODIF2_REQUEST_CODE)
        }

        modi3.setOnClickListener {
            val modi3Intent = Intent(this@calcul, modif3::class.java)
            modi3Intent.putExtra("pourcentage30", pourcentage30)
            startActivityForResult(modi3Intent, MODIF3_REQUEST_CODE)
        }

        modi4.setOnClickListener {
            val modi4Intent = Intent(this@calcul, modif4::class.java)
            modi4Intent.putExtra("pourcentage50", pourcentage50)
            startActivityForResult(modi4Intent, MODIF4_REQUEST_CODE)
        }

        modi5.setOnClickListener {
            val modi5Intent = Intent(this@calcul, modif5::class.java)
            modi5Intent.putExtra("pourcentage40", pourcentage40)
            startActivityForResult(modi5Intent, MODIF5_REQUEST_CODE)
        }

        // Other buttons and click listeners...

        button35.setOnClickListener {
            if (pourcentage40 > 0) {
                pourcentage20++
                pourcentage40--
                textView8.text = "Education: ${pourcentage20}Dnt"
                textView12.text = "Autre: ${pourcentage40}Dnt"
            }
            updateTextView4()
        }

        button17.setOnClickListener {
            if (pourcentage20 > 0) {
                pourcentage20--
                pourcentage40++
                textView8.text = "Education: ${pourcentage20}Dnt"
                textView12.text = "Autre: ${pourcentage40}Dnt"
            }
            updateTextView4()
        }
        button18.setOnClickListener {
            if (pourcentage40 > 0) {
                // Incrémenter pourcentage10 et décrémenter pourcentage40
                pourcentage10++
                pourcentage40--

                // Mettre à jour les TextView avec les nouveaux pourcentages
                textView9.text = "Santé: ${pourcentage10}Dnt"
                textView12.text = "Autre: ${pourcentage40}Dnt"
            }
            updateTextView4()}
        button19.setOnClickListener {
            if (pourcentage10 > 0) {


                // Décrémenter pourcentage10 et incrémenter pourcentage40
                pourcentage10--
                pourcentage40++

                // Mettre à jour les TextView avec les nouveaux pourcentages
                textView9.text = "Santé: ${pourcentage10}Dnt"
                textView12.text = "Autre: ${pourcentage40}Dnt"
            }
            updateTextView4()}
        button22.setOnClickListener {
            if (pourcentage40 > 0) {
                // Incrémenter pourcentage10 et décrémenter pourcentage40
                pourcentage30++
                pourcentage40--

                // Mettre à jour les TextView avec les nouveaux pourcentages
                textView10.text = "Alimentation: ${pourcentage30}Dnt"
                textView12.text = "Autre: ${pourcentage40}Dnt"
            }
            updateTextView4()}
        button23.setOnClickListener {
            if (pourcentage30 > 0) {


                // Décrémenter pourcentage10 et incrémenter pourcentage40
                pourcentage30--
                pourcentage40++

                // Mettre à jour les TextView avec les nouveaux pourcentages
                textView10.text = "Alimentation: ${pourcentage30}Dnt"
                textView12.text = "Autre: ${pourcentage40}Dnt"
            }
            updateTextView4()}
        button24.setOnClickListener { if (pourcentage40 > 0) {
            // Incrémenter pourcentage10 et décrémenter pourcentage40
            pourcentage50++
            pourcentage40--

            // Mettre à jour les TextView avec les nouveaux pourcentages
            textView11.text = "Transport: ${pourcentage50}Dnt"
            textView12.text = "Autre: ${pourcentage40}Dnt"
        }
            updateTextView4()}
        button25.setOnClickListener {
            if (pourcentage50 > 0) {


                // Décrémenter pourcentage10 et incrémenter pourcentage40
                pourcentage50--
                pourcentage40++

                // Mettre à jour les TextView avec les nouveaux pourcentages
                textView11.text = "Transport: ${pourcentage50}Dnt"
                textView12.text = "Autre: ${pourcentage40}Dnt"
            }
            updateTextView4()}

        // Other button click listeners...
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            MODIF1_REQUEST_CODE -> {
                if (resultCode == RESULT_OK) {
                    val updatedPourcentage20 = data?.getIntExtra("updatedPourcentage20", pourcentage20) ?: pourcentage20
                    pourcentage20 = updatedPourcentage20
                    val textView8: TextView = findViewById(R.id.textView8)
                    textView8.text = "Education: ${pourcentage20}Dnt"
                    updateTextView4()
                }
            }
            MODIF2_REQUEST_CODE -> {
                if (resultCode == RESULT_OK) {
                    val updatedPourcentage10 = data?.getIntExtra("updatedPourcentage10", pourcentage10) ?: pourcentage10
                    pourcentage10 = updatedPourcentage10
                    val textView9: TextView = findViewById(R.id.textView9)
                    textView9.text = "Santé :    ${pourcentage10}Dnt"
                    updateTextView4()
                }
            }
            MODIF3_REQUEST_CODE -> {
                if (resultCode == RESULT_OK) {
                    val updatedPourcentage30 = data?.getIntExtra("updatedPourcentage30", pourcentage30) ?: pourcentage30
                    pourcentage30 = updatedPourcentage30
                    val textView10: TextView = findViewById(R.id.textView10)
                    textView10.text = "Alimentation: ${pourcentage30}Dnt"
                    updateTextView4()
                }
            }
            MODIF4_REQUEST_CODE -> {
                if (resultCode == RESULT_OK) {
                    val updatedPourcentage50 = data?.getIntExtra("updatedPourcentage50", pourcentage50) ?: pourcentage50
                    pourcentage50 = updatedPourcentage50
                    val textView11: TextView = findViewById(R.id.textView11)
                    textView11.text = "Transport: ${pourcentage50}Dnt"
                    updateTextView4()
                }
            }
            MODIF5_REQUEST_CODE -> {
                if (resultCode == RESULT_OK) {
                    val updatedPourcentage40 = data?.getIntExtra("updatedPourcentage40", pourcentage40) ?: pourcentage40
                    pourcentage40 = updatedPourcentage40
                    val textView12: TextView = findViewById(R.id.textView12)
                    textView12.text = "Autre: ${pourcentage40}Dnt"
                    updateTextView4()
                }
            }
        }
    }
    private fun updateTextView4() {
        val sommePourcentages = pourcentage10 + pourcentage20 + pourcentage30 + pourcentage40 + pourcentage50
        textView4.text = "Montant: $sommePourcentages Dnt"
    }
}
