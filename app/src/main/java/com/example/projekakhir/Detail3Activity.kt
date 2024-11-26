package com.example.projekakhir

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Detail3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_detail3)

        val itemName = intent.getStringExtra("itemName")
        val itemDetails = intent.getStringExtra("itemDetails")

        val detailItemName = findViewById<TextView>(R.id.namedetail)
        val detailItemDetails = findViewById<TextView>(R.id.detailitem)

        detailItemName.text = itemName
        detailItemDetails.text = itemDetails

        val exitButton = findViewById<Button>(R.id.exitButton)
        exitButton.setOnClickListener {
            finish()
        }
    }
}
