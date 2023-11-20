package com.example.affirmo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddActivity : AppCompatActivity() {
    private lateinit var _sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        _sharedPreferences = this.getSharedPreferences("affirmations", Context.MODE_PRIVATE)

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
            with (_sharedPreferences.edit()) {
                val userInput = edit_text.text.toString()
                val affirmations = _sharedPreferences.getStringSet("affirmationSet", mutableSetOf());
                val newAffirmations = mutableSetOf(userInput)
                if (affirmations != null) {
                    newAffirmations.addAll(affirmations)
                }
                putStringSet("affirmationSet", newAffirmations)
                apply()
            }
        }
    }
}