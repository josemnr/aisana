package com.example.proyecto_moviles.Activities

import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_moviles.Fragments.TimePickerFragment
import com.example.proyecto_moviles.R
import com.parse.GetCallback
import com.parse.ParseException
import com.parse.ParseObject
import com.parse.ParseQuery
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


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

        val query = ParseQuery<ParseObject>("Schedule")
        query.whereEqualTo("objectId", "Fqvbh31GbT")
        query.getFirstInBackground { obj, e ->
            if (e == null){
                etOpeningTime.hint = "Opening time: " + obj["Opening_Time"] as String
                etClosingTime.hint = "Closing time: " + obj["Closing_Time"] as String
                etBreakTime.hint = "Break time: " + obj["Break_Time"] as String
            }else{
                error { e }
            }
        }


        btnAgendar.setOnClickListener(){

            val queryt = ParseQuery.getQuery<ParseObject>("Schedule")
            queryt.getInBackground("Fqvbh31GbT") { schedule, e ->
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.
                    if(etOpeningTime.text.toString() == "" && etClosingTime.text.toString() != "" && etBreakTime.text.toString() != ""){
                        schedule.put("Closing_Time", etClosingTime.text.toString())
                        schedule.put("Break_Time",etBreakTime.text.toString())
                    }
                    else if(etOpeningTime.text.toString() != "" && etClosingTime.text.toString() == "" && etBreakTime.text.toString() == ""){
                        schedule.put("Opening_Time", etOpeningTime.text.toString())
                    }
                    else if(etOpeningTime.text.toString() != "" && etClosingTime.text.toString() == "" && etBreakTime.text.toString() != ""){
                        schedule.put("Opening_Time", etOpeningTime.text.toString())
                        schedule.put("Break_Time",etBreakTime.text.toString())
                    }
                    else if(etOpeningTime.text.toString() == "" && etClosingTime.text.toString() != "" && etBreakTime.text.toString() == ""){
                        schedule.put("Closing_Time", etClosingTime.text.toString())
                    }
                    else if(etOpeningTime.text.toString() != "" && etClosingTime.text.toString() != "" && etBreakTime.text.toString() == ""){
                        schedule.put("Opening_Time", etOpeningTime.text.toString())
                        schedule.put("Closing_Time", etClosingTime.text.toString())
                    }
                    else if(etOpeningTime.text.toString() == "" && etClosingTime.text.toString() == "" && etBreakTime.text.toString() != ""){
                        schedule.put("Break_Time",etBreakTime.text.toString())
                    }
                    else{
                        schedule.put("Opening_Time", etOpeningTime.text.toString())
                        schedule.put("Closing_Time", etClosingTime.text.toString())
                        schedule.put("Break_Time", etBreakTime.text.toString())
                    }
                    schedule.saveInBackground()
                } else {
                    // Failed
                }
            }

            Toast.makeText(this, "Los datos se han actualizado", Toast.LENGTH_LONG).show()
            startActivity<ActivityMain>()
            //TODO implement ParseSaveSchedule
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
