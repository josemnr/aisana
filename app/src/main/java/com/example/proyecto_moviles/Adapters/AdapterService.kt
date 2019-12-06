package com.example.proyecto_moviles.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_moviles.Activities.Activity_appointment_description
import com.example.proyecto_moviles.R
import org.jetbrains.anko.startActivity

class AdapterService (private val service_names: ArrayList<String>,private val services_prices: ArrayList<Int>):RecyclerView.Adapter<NameViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.individual_service, parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int = service_names.size

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(service_names[position], services_prices[position])
    }
}

class NameViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val nameTitle: TextView = view.findViewById(R.id.item_title_name)
    private val priceTitle: TextView = view.findViewById(R.id.item_price)
    private val itemCard: ConstraintLayout = view.findViewById(R.id.item_card)

    fun bind(service: String, price : Int) {
        nameTitle.text = service
        priceTitle.text = "$ $price"
        itemCard.setOnClickListener{

        }
    }
}