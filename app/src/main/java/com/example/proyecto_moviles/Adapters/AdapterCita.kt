package com.example.proyecto_moviles.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_moviles.R

class AdapterCita (private val service_names: ArrayList<String>):RecyclerView.Adapter<CitaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.individual_service, parent, false)
        return CitaViewHolder(view)
    }

    override fun getItemCount(): Int = service_names.size

    override fun onBindViewHolder(holder: CitaViewHolder, position: Int) {
        holder.bind(service_names[position])
    }
}

class CitaViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val nameTitle: TextView = view.findViewById(R.id.item_title_name)

    fun bind(service: String) {
        nameTitle.text = service
    }
}