package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class pageIntro : AppCompatActivity() {
    private lateinit var welcomeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro)

        setSupportActionBar(findViewById(R.id.toolbar))

        welcomeTextView = findViewById(R.id.textView15)
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val savedName = sharedPreferences.getString("name", "")

        if (!savedName.isNullOrEmpty()) {
            val welcomeMessage = "Bienvenue, $savedName !"
            welcomeTextView.text = welcomeMessage
        }

        val aboutButton: Button = findViewById(R.id.button2)
        val startButton: Button = findViewById(R.id.button3)

        aboutButton.setOnClickListener {

            val aboutIntent = Intent(this@pageIntro, apropos::class.java)
            startActivity(aboutIntent)
        }

        startButton.setOnClickListener {

            val startIntent = Intent(this@pageIntro,MainActivity2::class.java)
            startActivity(startIntent)
        }
    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_page_intro, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {

                val loginIntent = Intent(this@pageIntro, loginn::class.java)
                startActivity(loginIntent)
                finish()
                invalidateOptionsMenu()
                true
            }
            R.id.action_profile -> {
                val profileIntent = Intent(this@pageIntro, profile::class.java)
                startActivity(profileIntent)
                true
            }

            R.id.action_exit -> {
                // Fermer l'application
                finishAffinity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}