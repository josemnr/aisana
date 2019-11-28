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
    private lateinit var etDate : EditText
    private lateinit var etTime : EditText
    private lateinit var confirmBtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar)

        etDate = find(R.id.Fecha_Et)
        etTime = find(R.id.Hora_Et)
        confirmBtn = find(R.id.agendar_confirm_button)

        confirmBtn.setOnClickListener(){

            //TODO Parse set appointment here

            startActivity<ActivityProfile>()
        }

        etDate.setOnClickListener(){
            showDatePickerDialog()
        }

        etTime.setOnClickListener(){
            showTimePickerDialog()
        }
    }


    //////////////////////////////Inicializacion y show de los fragmentos//////////////////
    private fun showDatePickerDialog(){
        val newFragment = DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, day ->

            //Enero es 0
            val selectDate = day.toString() + "/" + (month+1) + "/" + year
            etDate.setText(selectDate)

        }, this)
        newFragment.show(supportFragmentManager, "datePicker")
    }

    private fun showTimePickerDialog(){
        val newFragment = TimePickerFragment.newInstance(TimePickerDialog.OnTimeSetListener{_, hour, min ->
            //0 son las 00hrs
            val selectTime = hour.toString() + ":" + min.toString()
            etTime.setText(selectTime)

        }, this)

        newFragment.show(supportFragmentManager, "TimePicker")
    }
}