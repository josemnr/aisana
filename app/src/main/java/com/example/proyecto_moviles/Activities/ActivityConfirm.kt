package com.example.proyecto_moviles.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.proyecto_moviles.R

class ActivityConfirm : AppCompatActivity() {

    private lateinit var mDone: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        mDone = findViewById(R.id.confirm_button)

        //parse fetch appointment data here

        mDone.setOnClickListener{
            //startActivity<ActivityProfile>()
        }

    }
}
