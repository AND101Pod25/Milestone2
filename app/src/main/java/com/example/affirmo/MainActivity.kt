package com.example.affirmo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import kotlin.random.Random

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}
class MainActivity : AppCompatActivity() {
    private lateinit var quote: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.refresh_affirmation)
        val tView = findViewById<TextView>(R.id.affirmation)
        quote = String()
        getData()
        getNextImage(button,tView)
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
