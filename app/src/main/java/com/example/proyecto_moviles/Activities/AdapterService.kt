package com.example.proyecto_moviles.Activities

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_moviles.R

/*class AdapterService(private val services: ArrayList<HashMap<String, String>>): RecyclerView.Adapter<ServiceViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.individual_service, parent, false)
        return ServiceViewHolder(view)
    }
    override fun getItemCount(): Int = services.size
    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(services[position])
    }
}
class ServiceViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val serviceName: TextView = view.findViewById(R.id.item_title_name)
    fun bind(service: HashMap<String, String>) {
        serviceName.text = service.get("name")
    }
}
 */

/////////////////////////////////////


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