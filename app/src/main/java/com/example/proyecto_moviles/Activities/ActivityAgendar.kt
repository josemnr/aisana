package com.example.proyecto_moviles.Activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_moviles.Fragments.DatePickerFragment
import com.example.proyecto_moviles.Fragments.TimePickerFragment
import com.example.proyecto_moviles.R
import com.parse.ParseObject
import com.parse.ParseUser
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ActivityAgendar : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    ///////////////////////Edit text del layout
    private lateinit var serviceNameEditText : EditText
    private lateinit var stylistEditText : EditText
    private lateinit var dateEditText : EditText
    private lateinit var timeEditText : EditText
    private lateinit var confirmButton : Button
    private lateinit var cancelButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar)

        val user = ParseUser.getCurrentUser()
        val userName = user.username.toString()

        serviceNameEditText = findViewById(R.id.Sevicio_Et)
        stylistEditText = findViewById(R.id.estilista_Et)
        dateEditText = findViewById(R.id.Fecha_Et)
        timeEditText = findViewById(R.id.Hora_Et)
        confirmButton = findViewById(R.id.agendar_confirm_button)
        cancelButton = findViewById(R.id.cancel_button_activityAgendar)

        serviceNameEditText.setOnClickListener(){
            showPopupServices(this.serviceNameEditText)
        }

        stylistEditText.setOnClickListener(){
            showPopupStylists(this.stylistEditText)
        }

        dateEditText.setOnClickListener{
            showDatePickerDialog()
        }

        timeEditText.setOnClickListener{
            showTimePickerDialog()
        }

        confirmButton.setOnClickListener {

            if(serviceNameEditText.text.isEmpty() || stylistEditText.text.isEmpty() || dateEditText.text.isEmpty() || timeEditText.text.isEmpty()){
                toast("Error, please fill all fields properly")
                return@setOnClickListener
            }

            val appointmentObject = ParseObject("Appointment")
            appointmentObject.put("Service", serviceNameEditText.text.toString())
            appointmentObject.put("Stylist", stylistEditText.text.toString())
            appointmentObject.put("User", userName)
            appointmentObject.put("Date", dateEditText.text.toString())
            appointmentObject.put("Time", timeEditText.text.toString())
            appointmentObject.saveInBackground()

            startActivity<ActivityProfile>()
        }

        cancelButton.setOnClickListener(){
            startActivity<ActivityProfile>()
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
            timeEditText.setText(selectTime)

        }, this)

        newFragment.show(supportFragmentManager, "TimePicker")
    }

    private fun showPopupServices(v : View){
        val popupMenu = PopupMenu(this, v)
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.inflate(R.menu.services_popup_menu)
        popupMenu.show()
    }

    private fun showPopupStylists(v : View){
        val popupMenu = PopupMenu(this, v)
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.inflate(R.menu.stylists_popup_menu)
        popupMenu.show()
    }

    override fun onMenuItemClick(view: MenuItem?): Boolean {
        when(view!!.itemId){
            R.id.service1 -> putService(view)
            R.id.service2 -> putService(view)
            R.id.service3 -> putService(view)
            R.id.service4 -> putService(view)
            R.id.service5 -> putService(view)
            R.id.service6 -> putService(view)
            R.id.stylist1 -> putStylist(view)
            R.id.stylist2 -> putStylist(view)
            R.id.stylist3 -> putStylist(view)
            R.id.stylist4 -> putStylist(view)
            R.id.stylist5 -> putStylist(view)
        }
        return true
    }

    private fun putService(view: MenuItem?) {
        serviceNameEditText.setText(view!!.title)
    }

    private fun putStylist(view: MenuItem?) {
        stylistEditText.setText(view!!.title)
    }
}