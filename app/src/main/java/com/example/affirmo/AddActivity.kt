package com.example.affirmo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

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

        val save_button = findViewById<Button>(R.id.save_affirmation)
        val edit_text = findViewById<EditText>(R.id.editText)
        save_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", edit_text.text.toString());
            startActivity(intent)
        }
    }
}