package com.example.projekakhir

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.projekakhir.com.example.projekakhir.DetailPesanan
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ThirdActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var addressInput: EditText
    private lateinit var rentalPeriodInput: EditText
    private lateinit var rentInput: EditText
    private lateinit var priceInput: EditText
    private lateinit var transactionGroup: RadioGroup
    private lateinit var submitButton: Button

    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        database = FirebaseDatabase.getInstance("https://projectakhir-dc1f9-default-rtdb.asia-southeast1.firebasedatabase.app/")
        databaseReference = database.reference

        setContentView(R.layout.rent_activity)

        nameInput = findViewById(R.id.nameInp)
        phoneInput = findViewById(R.id.phoneInput)
        addressInput = findViewById(R.id.addressInput)
        rentalPeriodInput = findViewById(R.id.rentalPeriodInput)
        rentInput = findViewById(R.id.rentInput)
        priceInput = findViewById(R.id.priceInput)
        transactionGroup = findViewById(R.id.transaction)
        submitButton = findViewById(R.id.submitBtn)

        submitButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()
            val address = addressInput.text.toString().trim()
            val rentalPeriod = rentalPeriodInput.text.toString().trim()
            val rentalItem = rentInput.text.toString().trim()
            val price = priceInput.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty() ||
                rentalPeriod.isEmpty() || rentalItem.isEmpty() || price.isEmpty()
            ) {
                showToast("All fields must be filled.")
                return@setOnClickListener
            }

            val priceValue = price.toDoubleOrNull()
            if (priceValue == null || priceValue <= 0) {
                showToast("Please enter a valid price.")
                return@setOnClickListener
            }

            val transactionMethod = when (transactionGroup.checkedRadioButtonId) {
                R.id.cod -> "COD"
                R.id.Transfer -> "Transfer"
                else -> {
                    showToast("Please select a transaction method.")
                    return@setOnClickListener
                }
            }

            val rentalData = mapOf(
                "name" to name,
                "phone" to phone,
                "address" to address,
                "rentalPeriod" to rentalPeriod,
                "rentalItem" to rentalItem,
                "price" to price,
                "transaction" to transactionMethod
            )

            val rentalRequestRef = databaseReference.child("rentalRequests").push()
            rentalRequestRef.setValue(rentalData)
                .addOnSuccessListener {
                    Log.d("Firebase", "Data successfully written: $rentalData")
                    showToast("Rental request submitted successfully.")

                    val intent = Intent(this, DetailPesanan::class.java).apply {
                        putExtra("name", name)
                        putExtra("phone", phone)
                        putExtra("address", address)
                        putExtra("rentalPeriod", rentalPeriod)
                        putExtra("rentalItem", rentalItem)
                        putExtra("price", price)
                        putExtra("transaction", transactionMethod)
                    }
                    startActivity(intent)
                }
                .addOnFailureListener { e ->
                    Log.e("FirebaseError", e.message ?: "Unknown error")
                    showToast("Error: ${e.message}")
                }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
