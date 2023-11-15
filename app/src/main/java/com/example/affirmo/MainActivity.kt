package com.example.affirmo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var quote: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.refresh_affirmation)
        val tView = findViewById<TextView>(R.id.affirmation)
        val intent = intent
        quote = intent.getStringExtra("key").toString()
        if (quote != "Insert your affirmation here...") {
            getData()
        }
        getNextImage(button,tView)
        val add_button = findViewById<Button>(R.id.add_button)
        add_button.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
        val menu_button = findViewById<Button>(R.id.menu_button)
        menu_button.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

    }
    private fun getData(){
        val client = AsyncHttpClient()
        val url = "https://zenquotes.io/api/quotes/[your_key]"
        val txtview : TextView = findViewById(R.id.affirmation)
        client[url , object :
            JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                if(json!=null) {
                    Log.d("debug obj","x")
                    val random = Random.nextInt(51)
                    val randomquote = json.jsonArray.getJSONObject(random).getString("q")

                    txtview.text = randomquote
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                txtview.text ="Respect is earned by effort not age, all things age without effort."
                Log.d("Failed",response.toString())
            }
        }
        ]
    }
    private fun getNextImage(button: Button, textView: TextView) {
        button.setOnClickListener {
            getData()
        }
    }
}
