package com.example.affirmo
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserAffirmationsActivity : AppCompatActivity(){
    private lateinit var _sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        _sharedPreferences = this.getSharedPreferences("affirmations", Context.MODE_PRIVATE)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_affirmations)

        val menu_button = findViewById<Button>(R.id.menu_button4)
        menu_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val make_affirmation_button = findViewById<Button>(R.id.add_button2)
        make_affirmation_button.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
        val refresh_affirmo_button = findViewById<Button>(R.id.refresh_affirmation2)

        val refreshAffirmation = {
            _: View? ->
            val txtview : TextView = findViewById(R.id.user_affirmo)
            val affirmations = _sharedPreferences.getStringSet("affirmationSet", mutableSetOf())

            if (affirmations != null && affirmations.size > 0 ) {
                txtview.text = affirmations.random()
            }
        }
        refresh_affirmo_button.setOnClickListener(refreshAffirmation)

        refreshAffirmation(null)

    }
}