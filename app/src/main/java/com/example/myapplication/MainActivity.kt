package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        handler = Handler()

        // lwa9t eli t7eb tlansi fih l page jeya
        handler.postDelayed({
            val intent = Intent(this@MainActivity, bienvenueActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
