package com.example.proyecto_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityEditServices : AppCompatActivity() {

    private lateinit var mAddService: Button
    private lateinit var mDone: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        mAddService = findViewById(R.id.AddService_button_activityServices)
        mDone = findViewById(R.id.Done_button_activityServices)

        val recyclerView = findViewById<RecyclerView>(R.id.services_RecyclerView)

        recyclerView.adapter = AdapterService(getParseServices())
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun getParseServices() : ArrayList<String> {
        //TODO:
        /********************************************************************
        * IMPLEMENT PARSE FETCH SERVICES HERE
        * *******************************************************************
        */


        val services = arrayListOf<String>()
        services.add("Service Name 1")
        services.add("Service Name 2")
        services.add("Service Name 3")
        services.add("Service Name 4")

        return services
    }
}
