package com.example.proyecto_moviles.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.proyecto_moviles.R
import com.parse.ParseObject
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ActivityEditCita() : AppCompatActivity() {

    private lateinit var username : String
    private lateinit var servicename : String
    private lateinit var date : String
    private lateinit var time : String

    private lateinit var doneButton: Button
    private lateinit var cancelButton: Button
    private lateinit var updateButton: Button

    private lateinit var userName: EditText
    private lateinit var serviceName: EditText
    private lateinit var textDate: EditText
    private lateinit var textTime: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_cita)

        doneButton = findViewById(R.id.Done_button_activity_edit_cita)
        cancelButton = findViewById(R.id.Cancel_button_activity_edit_cita)
        updateButton = findViewById(R.id.Update_button_activity_edit_cita)

        userName = findViewById(R.id.edit_appointment_service_et)
        serviceName = findViewById(R.id.edit_appointment_username_et)
        textDate = findViewById(R.id.edit_appointment_date_et)
        textTime = findViewById(R.id.edit_appointment_time_et)


        username = intent.getStringExtra("Username")
        servicename = intent.getStringExtra("Service")
        date = intent.getStringExtra("Date")
        time = intent.getStringExtra("Time")

        userName.text.clear()
        serviceName.text.clear()
        textDate.text.clear()
        textTime.text.clear()

        userName.text.append(username)
        serviceName.text.append(servicename)
        textDate.text.append(date)
        textTime.text.append(time)

        doneButton.setOnClickListener{
            startActivity<ActivityCitas>()
        }

        cancelButton.setOnClickListener{
            startActivity<ActivityCitas>()
            //TODO: PARSE DELETE APPOINTMENT
            toast("appointment cancelled")
        }

        updateButton.setOnClickListener{
            val appointmentObject = ParseObject("Appointment")
            appointmentObject.put("Service", serviceName.text.toString())
            appointmentObject.put("User", userName.text.toString())
            appointmentObject.put("Date", textDate.text.toString())
            appointmentObject.put("Time", textTime.text.toString())
            appointmentObject.saveInBackground()
        }
    }
}

