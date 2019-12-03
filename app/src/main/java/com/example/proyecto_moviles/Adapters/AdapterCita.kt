package com.example.proyecto_moviles.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_moviles.R

class AdapterCita (private val services_names: ArrayList<String>, private val usernames: ArrayList<String>, private val dates: ArrayList<String>, private val times: ArrayList<String>):RecyclerView.Adapter<CitaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.individual_appointment, parent, false)
        return CitaViewHolder(view)



    }

    override fun getItemCount(): Int = services_names.size

    override fun onBindViewHolder(holder: CitaViewHolder, position: Int) {
        holder.bind(services_names[position], usernames[position], dates[position], times[position])
    }

}

class CitaViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val nameTextView: TextView = view.findViewById(R.id.service_appointment_title_name)
    private val usernameTextView: TextView = view.findViewById(R.id.username_appointment)
    private val datesTextView: TextView = view.findViewById(R.id.date_appointment)
    private val timesTextView: TextView = view.findViewById(R.id.time_appointment)


    fun bind(service: String, username: String, dates: String, times: String) {
        nameTextView.text = service
        usernameTextView.text = username
        datesTextView.text = dates
        timesTextView.text = times
    }
}