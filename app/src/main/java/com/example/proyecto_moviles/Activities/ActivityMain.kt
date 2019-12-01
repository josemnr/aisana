package com.example.proyecto_moviles.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.proyecto_moviles.R
import com.parse.ParseUser
import org.jetbrains.anko.startActivity

class ActivityMain : AppCompatActivity(), View.OnClickListener {

    private lateinit var mEditSchedule: Button
    private lateinit var mEditServices: Button
    private lateinit var mViewAppointments: Button
    private lateinit var mChangeUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        mEditSchedule = findViewById(R.id.options_edit_schedule_btn)
        mEditServices = findViewById(R.id.options_edit_services_btn)
        mChangeUser = findViewById(R.id.options_change_user)
        mViewAppointments = findViewById(R.id.options_view_appointments_btn)

        mEditSchedule.setOnClickListener(this)
        mEditServices.setOnClickListener(this)
        mChangeUser.setOnClickListener(this)
        mViewAppointments.setOnClickListener(this)

    }

    override fun onClick(item: View?) {
        when(item?.id) {
            R.id.options_edit_schedule_btn -> {
                startActivity<ActivitySchedule>()
            }
            R.id.options_edit_services_btn -> {
                startActivity<ActivityServices>()
            }
            R.id.options_view_appointments_btn -> {
                startActivity<ActivityCitas>()
            }
            R.id.options_change_user -> {
                ParseUser.getCurrentUser()
                ParseUser.logOut()
                Toast.makeText(this, "Se ha cerrado tu sesiòn", Toast.LENGTH_LONG).show()
                startActivity<ActivityLogin>()
            }
        }
    }
}
