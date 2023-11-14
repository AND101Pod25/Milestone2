package com.example.affirmo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val menu_button2 = findViewById<Button>(R.id.menu_button2)
        menu_button2.setOnClickListener {
            // Move to the second activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}