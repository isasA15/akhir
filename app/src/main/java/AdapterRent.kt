package com.example.projekakhir

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRent(private val rentalList: List<RentalItem>) :

    RecyclerView.Adapter<AdapterRent.RentalViewHolder>() {

    class RentalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.rentInput)
        val itemDetails: TextView = itemView.findViewById(R.id.rentalPeriodInput)
    }
    data class RentalItem(
        val name: String,
        val details: String
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tampilan_awal, parent, false)
        return RentalViewHolder(view)
    }

    override fun onBindViewHolder(holder: RentalViewHolder, position: Int) {
        val rentalItem = rentalList[position]
        holder.itemName.text = rentalItem.name
        holder.itemDetails.text = rentalItem.details

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, Detail1Activity::class.java)
            intent.putExtra("itemName", rentalItem.name)
            intent.putExtra("itemDetails", rentalItem.details)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = rentalList.size
}
