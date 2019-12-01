package com.example.proyecto_moviles.Activities

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_moviles.Fragments.TimePickerFragment
import com.example.proyecto_moviles.R
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class ActivitySchedule: AppCompatActivity(){

    private lateinit var etOpeningTime : EditText
    private lateinit var etClosingTime : EditText
    private lateinit var etBreakTime : EditText
    private lateinit var btnAgendar : Button
    private lateinit var btnCancel : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_owner)

        etOpeningTime = find(R.id.opening_time_editText)
        etClosingTime = find(R.id.closing_time_editText)
        etBreakTime = find(R.id.break_time_editText)
        btnAgendar = find(R.id.confirm_button_activityEditSchedule)
        btnCancel = find(R.id.cancel_button_activityEditSchedule)

        btnAgendar.setOnClickListener(){
            Toast.makeText(this, "Los datos se han actualizado", Toast.LENGTH_LONG).show()

            //TODO implement ParseSaveSchedule

            startActivity<ActivityMain>()
        }

        etOpeningTime.setOnClickListener(){
            showTOpeningTime()
        }

        etClosingTime.setOnClickListener(){
            showTClosingTime()
        }

        etBreakTime.setOnClickListener(){
            showTBreakTime()
        }

        btnCancel.setOnClickListener(){
            startActivity<ActivityMain>()
        }
    }

    private fun showTOpeningTime(){
        val newFragment = TimePickerFragment.newInstance(TimePickerDialog.OnTimeSetListener{ _, hour, min ->
            //0 son las 00hrs
            val selectTime = hour.toString() + ":" + min.toString()
            etOpeningTime.setText(selectTime)

        }, this)

        newFragment.show(supportFragmentManager, "TimePicker")
    }
    private fun showTClosingTime(){
        val newFragment = TimePickerFragment.newInstance(TimePickerDialog.OnTimeSetListener{ _, hour, min ->
            //0 son las 00hrs
            val selectTime = hour.toString() + ":" + min.toString()
            etClosingTime.setText(selectTime)

        }, this)

        newFragment.show(supportFragmentManager, "TimePicker")
    }
    private fun showTBreakTime(){
        val newFragment = TimePickerFragment.newInstance(TimePickerDialog.OnTimeSetListener{ _, hour, min ->
            //0 son las 00hrs
            val selectTime = hour.toString() + ":" + min.toString()
            etBreakTime.setText(selectTime)

        }, this)

        newFragment.show(supportFragmentManager, "TimePicker")
    }
}
