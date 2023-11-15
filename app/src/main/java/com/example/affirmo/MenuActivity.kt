package com.example.affirmo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MenuActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ButtonAdapter
    private lateinit var buttonLabels: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        recyclerView = findViewById(R.id.recycler_view)
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        buttonLabels = mutableListOf("My Affirmations", "My Favorites", "Anxiety", "Change", "Choice", "Confidence", "Courage", "Death", "Dreams", "Excellence", "Failure", "Fairness", "Fear", "Forgiveness", "Freedom", "Future", "Happiness", "Inspiration", "Kindness", "Leadership", "Life", "Living", "Love", "Pain", "Past", "Success", "Time", "Today", "Truth", "Work")

        adapter = ButtonAdapter(buttonLabels)
        recyclerView.adapter = adapter

        val menu_button = findViewById<Button>(R.id.menu_button3)
        menu_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}

class ButtonAdapter(private val buttonList: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val BUTTON_TYPE_1 = 1
        private const val BUTTON_TYPE_2 = 2
    }

    override fun getItemViewType(position: Int): Int {
        // Return different view types based on position or any other criteria
        return if (position / 2 == 0) {
            BUTTON_TYPE_1
        } else {
            BUTTON_TYPE_2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            BUTTON_TYPE_1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.lilac_button_item, parent, false)
                ButtonViewHolder1(view)
            }
            BUTTON_TYPE_2 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.teal_button_item, parent, false)
                ButtonViewHolder2(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val buttonText = buttonList[position]
        when (holder.itemViewType) {
            BUTTON_TYPE_1 -> {
                val buttonViewHolder1 = holder as ButtonViewHolder1
                buttonViewHolder1.button.text = buttonText
            }
            BUTTON_TYPE_2 -> {
                val buttonViewHolder2 = holder as ButtonViewHolder2
                buttonViewHolder2.button.text = buttonText
            }
        }
    }

    override fun getItemCount(): Int {
        return buttonList.size
    }

    class ButtonViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.lilac_button)
    }

    class ButtonViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.teal_button)
    }
}
