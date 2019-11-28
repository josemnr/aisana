package com.example.proyecto_moviles.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_moviles.R
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseObject
import com.parse.ParseQuery
import org.jetbrains.anko.*

class ActivityServices : AppCompatActivity(){

    private lateinit var addServiceButton: Button
    private lateinit var doneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        val recyclerView = findViewById<RecyclerView>(R.id.services_RecyclerView)
        var services = arrayListOf<String>()

        addServiceButton = findViewById(R.id.AddService_button_activityServices)
        doneButton = findViewById(R.id.Done_button_activityServices)

        addServiceButton.setOnClickListener{
            startActivity<ActivityNewService>()
        }

        doneButton.setOnClickListener(){
            startActivity<ActivityMain>()
        }

        val query = ParseQuery.getQuery<ParseObject>("Service")

        query.findInBackground( object : FindCallback<ParseObject>{
            override fun done(objects: MutableList<ParseObject>?, e:
            ParseException?) {
                if (e == null) {
                    val relationQuery: ParseQuery<ParseObject> = ParseQuery.getQuery("Service")
                    relationQuery.findInBackground()

                    for(service in objects?.indices!!){
                        services.add(objects.get(service).getString("NameOfService")!!)
                    }
                    recyclerView.adapter = AdapterService(services)
                    recyclerView.layoutManager = LinearLayoutManager(this@ActivityServices)

                } else {
                    Log.wtf("Error", e.localizedMessage)
                }
            }
        })

    }

}
