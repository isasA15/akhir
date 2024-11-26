package com.example.projekakhir

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Detail2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_detail2)

        val itemName = intent.getStringExtra("itemName")
        val itemDetails = intent.getStringExtra("itemDetails")

        val detailItemName2 = findViewById<TextView>(R.id.namedetail2)
        val detailItemDetails2 = findViewById<TextView>(R.id.detailitem2)

        detailItemName2.text = itemName
        detailItemDetails2.text = itemDetails

        val exitButton2 = findViewById<Button>(R.id.exitButton2)
        exitButton2.setOnClickListener {
            finish()
        }
    }
}

