package com.example.proyecto_moviles.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_moviles.Adapters.AdapterCita
import com.example.proyecto_moviles.Adapters.AdapterService
import com.example.proyecto_moviles.R
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseObject
import com.parse.ParseQuery
import org.jetbrains.anko.*

class ActivityCitas : AppCompatActivity(){

    private lateinit var doneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_citas)

        val recyclerView = findViewById<RecyclerView>(R.id.appointment_RecyclerView)
        var citas = arrayListOf<String>()
        var usernames = arrayListOf<String>()
        var dates = arrayListOf<String>()
        var times = arrayListOf<String>()


        doneButton = findViewById(R.id.Done_button_activityCitas)

        doneButton.setOnClickListener(){
            startActivity<ActivityMain>()
        }

        val query = ParseQuery.getQuery<ParseObject>("Appointment")

        query.findInBackground( object : FindCallback<ParseObject>{
            override fun done(objects: MutableList<ParseObject>?, e:
            ParseException?) {
                if (e == null) {
                    val relationQuery: ParseQuery<ParseObject> = ParseQuery.getQuery("Appointment")
                    relationQuery.findInBackground()

                    for(service in objects?.indices!!){
                        citas.add(objects.get(service).getString("Service")!!)
                        usernames.add(objects.get(service).getString("User")!!)
                        dates.add(objects.get(service).getString("Date")!!)
                        times.add(objects.get(service).getString("Time")!!)
                    }
                    recyclerView.adapter =
                        AdapterCita(citas, usernames, dates, times)
                    recyclerView.layoutManager = LinearLayoutManager(this@ActivityCitas)

                } else {
                    Log.wtf("Error", e.localizedMessage)
                }
            }
        })

    }

}
