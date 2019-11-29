package com.example.proyecto_moviles.Activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_moviles.Fragments.DatePickerFragment
import com.example.proyecto_moviles.Fragments.TimePickerFragment
import com.example.proyecto_moviles.R
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class ActivityAgendar : AppCompatActivity(){
    ///////////////////////Edit text del layout
    private lateinit var serviceNameEditText : EditText
    private lateinit var stylistEditText : EditText
    private lateinit var dateEditText : EditText
    private lateinit var timeEditText : EditText
    private lateinit var confirmButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar)

        serviceNameEditText = findViewById(R.id.Sevicio_Et)
        stylistEditText = findViewById(R.id.estilista_Et)
        dateEditText = findViewById(R.id.Fecha_Et)
        timeEditText = findViewById(R.id.Hora_Et)


        confirmButton.setOnClickListener(){

            //TODO Parse set appointment here

            startActivity<ActivityProfile>()
        }

        dateEditText.setOnClickListener(){
            showDatePickerDialog()
        }

        timeEditText.setOnClickListener(){
            showTimePickerDialog()
        }
    }


    //////////////////////////////Inicializacion y show de los fragmentos//////////////////
    private fun showDatePickerDialog(){
        val newFragment = DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, day ->

            //Enero es 0
            val selectDate = day.toString() + "/" + (month+1) + "/" + year
            dateEditText.setText(selectDate)

        }, this)
        newFragment.show(supportFragmentManager, "datePicker")
    }

    private fun showTimePickerDialog(){
        val newFragment = TimePickerFragment.newInstance(TimePickerDialog.OnTimeSetListener{_, hour, min ->
            //0 son las 00hrs
            val selectTime = hour.toString() + ":" + min.toString()
            dateEditText.setText(selectTime)

        }, this)

        newFragment.show(supportFragmentManager, "TimePicker")
    }
}