package com.example.projekakhir.com.example.projekakhir

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projekakhir.R
import com.example.projekakhir.SecondActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CriticActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        database = FirebaseDatabase.getInstance("https://projectakhir-dc1f9-default-rtdb.asia-southeast1.firebasedatabase.app/")
        databaseReference = database.reference

        setContentView(R.layout.critic_layout)

        val feedbackInput = findViewById<EditText>(R.id.feedbackInput)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val submitFeedbackBtn = findViewById<Button>(R.id.submitFeedbackBtn)
        val exitButton3 = findViewById<Button>(R.id.exitButton3)

        submitFeedbackBtn.setOnClickListener {
            val feedback = feedbackInput.text.toString()
            val rating = ratingBar.rating

            if (feedback.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "Thank you, \nFeedback: $feedback\nRating: $rating stars",
                    Toast.LENGTH_LONG
                ).show()

                feedbackInput.text.clear()
                ratingBar.rating = 3.5f
            }
        }

        exitButton3.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
