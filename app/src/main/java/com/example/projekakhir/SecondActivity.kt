package com.example.projekakhir

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.projekakhir.com.example.projekakhir.CriticActivity

class SecondActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tampilan_awal)

        val wantToRentCard = findViewById<CardView>(R.id.wantToRent)
        wantToRentCard.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        val kedetail1 = findViewById<CardView>(R.id.cameradetail1)
        kedetail1.setOnClickListener {
            val intent = Intent(this, Detail1Activity::class.java)
            startActivity(intent)
        }
        val kedetail2 = findViewById<CardView>(R.id.cameradetail2)
        kedetail2.setOnClickListener {
            val intent = Intent(this, Detail2Activity::class.java)
            startActivity(intent)
        }
        val kedetail3 = findViewById<CardView>(R.id.cameradetail3)
        kedetail3.setOnClickListener {
            val intent = Intent(this, Detail3Activity::class.java)
            startActivity(intent)
        }
        val profile = findViewById<CardView>(R.id.ourprofile)
        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        val critic = findViewById<CardView>(R.id.critic)
        critic.setOnClickListener {
            val intent = Intent(this, CriticActivity::class.java)
            startActivity(intent)
        }
        val home = findViewById<Button>(R.id.btn_logout)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
