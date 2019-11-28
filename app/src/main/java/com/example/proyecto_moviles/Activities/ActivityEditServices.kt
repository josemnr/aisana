package com.example.proyecto_moviles.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_moviles.R
import org.jetbrains.anko.startActivity

class ActivityEditServices : AppCompatActivity() {

    private lateinit var mAddService: Button
    private lateinit var mDone: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        mAddService = findViewById(R.id.AddService_button_activityServices)
        mDone = findViewById(R.id.Done_button_activityServices)

        val recyclerView = findViewById<RecyclerView>(R.id.services_RecyclerView)

        recyclerView.adapter =
            AdapterService(getParseServices())
        recyclerView.layoutManager = LinearLayoutManager(this)

        mAddService.setOnClickListener{
            startActivity<ActivityNewService>()
        }

        mDone.setOnClickListener{
            startActivity<ActivityMain>()
        }
    }

    fun getParseServices() : ArrayList<String> {
        //TODO:
        /********************************************************************
        * IMPLEMENT PARSE FETCH SERVICES HERE
        * *******************************************************************
        */


        val services = arrayListOf<String>()
        services.add("Corte de Cabello")
        services.add("Tinte de pelo")
        services.add("Maquillaje express")
        services.add("Flamboyage")
        services.add("Retoques")
        services.add("Peinado Formal")
        services.add("Aplicacion Gelish")
        services.add("Manicura")


        return services
    }
}
