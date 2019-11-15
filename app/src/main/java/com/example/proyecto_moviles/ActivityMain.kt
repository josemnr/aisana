package com.example.proyecto_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.find
import java.nio.file.Files.find

class ActivityMain : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewSchedule: Button
    private lateinit var mEditSchedule: Button
    private lateinit var mEditServices: Button
    private lateinit var mChangeUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        mViewSchedule = find(R.id.options_view_schedule_btn)
        mEditSchedule = find(R.id.options_edit_schedule_btn)
        mEditServices = find(R.id.options_edit_services_btn)
        mChangeUser = find(R.id.options_change_user)

        mViewSchedule.setOnClickListener(this)
        mEditSchedule.setOnClickListener(this)
        mEditServices.setOnClickListener(this)
        mChangeUser.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
