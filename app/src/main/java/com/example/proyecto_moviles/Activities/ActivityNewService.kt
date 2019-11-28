package com.example.proyecto_moviles.Activities

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_moviles.Fragments.TimePickerFragment
import com.example.proyecto_moviles.R
import com.parse.ParseObject
import org.jetbrains.anko.startActivity

class ActivitynewService: AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var availableStartEditText: EditText
    private lateinit var availableEndEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var confirmButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_service)

        nameEditText = findViewById(R.id.edit_service_name_et)
        availableStartEditText = findViewById(R.id.edit_service_start_time_et)
        availableEndEditText = findViewById(R.id.edit_service_end_time_et)
        descriptionEditText = findViewById(R.id.edit_service_description_et)
        confirmButton = findViewById(R.id.edit_service_confirm_button)
        cancelButton = findViewById(R.id.edit_service_cancel_button)

        availableStartEditText.setOnClickListener(){
            showTimePickerDialog(this.availableStartEditText)
        }
        availableEndEditText.setOnClickListener(){
            showTimePickerDialog(this.availableEndEditText)
        }

        confirmButton.setOnClickListener(){
            val nameValue = nameEditText.text.toString()
            val startValue = availableStartEditText
            val endValue = availableEndEditText.text.toString()
            val descriptionValue = descriptionEditText.text.toString()
            val serviceObject = ParseObject("Service")
            serviceObject.put("NameOfService", nameValue)
            //serviceObject.put("AvailableStart", startValue)
            //serviceObject.put("AvailableEnd", endValue)
            serviceObject.put("Description", descriptionValue)
            serviceObject.saveInBackground()
            nameEditText.text!!.clear()
            availableStartEditText.text!!.clear()
            availableEndEditText.text!!.clear()
            descriptionEditText.text!!.clear()
        }
        cancelButton.setOnClickListener(){
            startActivity<ActivityServices>()
        }
    }

    //////////////////////////////Inicializacion y show de los fragmentos//////////////////

    private fun showTimePickerDialog(editText: EditText) {
        val newFragment = TimePickerFragment.newInstance(TimePickerDialog.OnTimeSetListener{ _, hour, min ->
            //0 son las 00hrs
            val selectTime = hour.toString() + ":" + min.toString()
            editText.setText(selectTime)

        }, this)

        newFragment.show(supportFragmentManager, "TimePicker")
    }
}