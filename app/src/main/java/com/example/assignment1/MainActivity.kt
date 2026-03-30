package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.util.Log
class MainActivity : AppCompatActivity() {

    lateinit var edtTime: EditText
    lateinit var txtResult: TextView
    lateinit var btnSuggest: Button
    lateinit var btnReset: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edtTime = findViewById(R.id.edtTime)
        txtResult = findViewById(R.id.txtResult)
        btnSuggest = findViewById(R.id.btnSuggest)
        btnReset = findViewById(R.id.btnReset)

        btnSuggest.setOnClickListener {

            val time = edtTime.text.toString()
            var suggestion: String

            // IF Statements
            if (time == "Morning") {
                suggestion = "Send a good morning text to a family member"
            }
            else if (time == "Mid-morning") {
                suggestion = "Send a thank you message to a colleague"
            }
            else if (time == "Afternoon") {
                suggestion = "Share a funny meme with a friend"
            }
            else if (time == "Afternoon Snack Time") {
                suggestion = "Send a thinking of you message"
            }
            else if (time == "Dinner") {
                suggestion = "Call a friend for 5 minutes"
            }
            else if (time == "After Dinner" || time == "Night") {
                suggestion = "Leave a comment on a friend's post"
            }
            // Error handling
            else if (time == "") {
                suggestion = "Please enter a valid time (e.g. Morning, Afternoon)"
            }
            else {
                suggestion = "Invalid input. Try Morning, Afternoon, Dinner, etc"
            }

            txtResult.text = suggestion

            // Logging added
            Log.d("INPUT", "User entered: $time")
            Log.d("OUTPUT", "Suggestion: $suggestion")
        }

        // Reset button added
        btnReset.setOnClickListener {
            edtTime.text.clear()
            txtResult.text = ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}