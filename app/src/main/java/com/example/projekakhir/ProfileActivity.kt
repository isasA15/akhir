package com.example.projekakhir

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_layout)

        val exitButton = findViewById<Button>(R.id.exitButton3)
        exitButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}
