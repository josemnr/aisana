package com.example.proyecto_moviles.Fragments


import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.example.proyecto_moviles.R
import java.util.*

class TimePickerFragment(private val bcontext: Context): DialogFragment() {

    private var tlistener : TimePickerDialog.OnTimeSetListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_time_pick, container, false)
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val min = c.get(Calendar.MINUTE)
        return TimePickerDialog(bcontext, tlistener, hour, min, true)
    }

    companion object{
        fun newInstance(listener: TimePickerDialog.OnTimeSetListener, context: Context): TimePickerFragment{
            val fragment = TimePickerFragment(context)
            fragment.tlistener = listener
            return fragment
        }
    }
}
