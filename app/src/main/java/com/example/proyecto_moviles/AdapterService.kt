package com.example.proyecto_moviles

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterService (private val service_names: ArrayList<String>):RecyclerView.Adapter<NameViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.individual_service, parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int = service_names.size

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(service_names[position])
    }
}

class NameViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val nameTitle: TextView = view.findViewById(R.id.item_title_name)

    fun bind(service: String) {
        nameTitle.text = service
    }
}