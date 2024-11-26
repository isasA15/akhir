package com.example.projekakhir.com.example.projekakhir

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projekakhir.R
import com.example.projekakhir.SecondActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DetailPesanan : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = FirebaseDatabase.getInstance("https://projectakhir-dc1f9-default-rtdb.asia-southeast1.firebasedatabase.app/")
        databaseReference = database.reference

        setContentView(R.layout.detailpesanan)

        val name = intent.getStringExtra("name") ?: "Unknown"
        val phone = intent.getStringExtra("phone") ?: "Unknown"
        val address = intent.getStringExtra("address") ?: "Unknown"
        val rentalItem = intent.getStringExtra("rentalItem") ?: "Unknown"
        val price = intent.getStringExtra("price") ?: "0"
        val transaction = intent.getStringExtra("transaction") ?: "Unknown"

        val rentalPeriod: TextView = findViewById(R.id.rentalPeriod)
        val detailAddress: TextView = findViewById(R.id.detailAddress)
        val orderStatus: TextView = findViewById(R.id.orderStatus)
        val detailPrice: TextView = findViewById(R.id.detailPrice)
        val detailDeliveryFee: TextView = findViewById(R.id.detailDeliveryFee)
        val detailTotalPrice: TextView = findViewById(R.id.detailTotalPrice)

        detailAddress.text = address
        orderStatus.text = "Status: Pending Confirmation"
        detailPrice.text = "IDR $price"
        detailDeliveryFee.text = "IDR 10,000"
        val totalPrice = price.toDoubleOrNull()?.plus(10000) ?: 0.0
        detailTotalPrice.text = "IDR $totalPrice"

        val backToHomeButton: Button = findViewById(R.id.backToHomeButton)
        backToHomeButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
